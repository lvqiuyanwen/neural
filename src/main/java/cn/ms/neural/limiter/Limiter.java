package cn.ms.neural.limiter;

import java.util.List;

import cn.ms.micro.common.URL;
import cn.ms.micro.extension.Scope;
import cn.ms.micro.extension.Spi;

/**
 * The Current limiter <br>
 * <br>
 * 1.管理端添加限流规则<br>
 * 2.流量到来,开始校验流量是否超额<br>
 * 3.更新流量统计<br>
 * <br>
 * 数据结构:<br>
 * 1.KEY-->Statistics Number<br>
 * 2.KEY-->Max Number<br>
 * 
 * @author lry
 */
@Spi(scope = Scope.SINGLETON)
public interface Limiter {

	boolean start(URL url);

	boolean increment(String... keys);

	boolean increment(List<String> keys);

	boolean increment(Long expire, String... keys);

	boolean increment(Long expire, List<String> keys);

	List<LimiterRule> queryRules(String keywords);

	List<LimiterStatistics> queryStatistics(String keywords);

	void shutdown();
}