package com.storyhasyou.example.cloud.rules;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author fangxi
 * @date 2020/3/14
 * 基于一致性哈希算法的负载均衡
 */
@NoArgsConstructor
public class ConsistentHashingRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    public Server choose(ILoadBalancer lb, Object key) {
        // 获取 HttpServletRequest
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 使用url做摘要
        String uri = request.getServletPath() + "?" + request.getQueryString();
        return this.route(Objects.hash(uri), lb.getAllServers());

    }

    @Override
    public Server choose(Object key) {
        return this.choose(getLoadBalancer(), key);
    }

    private Server route(int hash, List<Server> servers) {
        if (CollectionUtils.isEmpty(servers)) {
            return null;
        }
        // 初始化圆环
        TreeMap<Long, Server> address = new TreeMap<>();
        servers.forEach(server -> {
            // 将每个服务分布在圆环上10个. todo 需要改成均匀分布
            for (int i = 0; i < 10; i++) {
                address.put(this.hash(server.getId() + i), server);
            }
        });
        // tailMap 获取最进比传入值要大的所有元素
        SortedMap<Long, Server> last = address.tailMap(this.hash(String.valueOf(hash)));
        // 如果没有比传入要大的元素, 当requestUrl是最后一个节点 获取圆环第一个
        if (CollectionUtils.isEmpty(last)) {
            return address.firstEntry().getValue();
        }
        return last.get(last.firstKey());
    }

    /**
     * 生成摘要
     */
    private long hash(String key) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] bytes = key.getBytes(StandardCharsets.UTF_8);
        md5.update(bytes);
        byte[] digest = md5.digest();
        // 用前三个元素生成摘要
        int hashCode = (digest[2] & 0xFF << 16) | (digest[1] & 0xFF << 8) | (digest[0] & 0xFF);
        return hashCode & 0xFFFFFFFFL;
    }
}
