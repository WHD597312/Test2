package com.peihou.pojo;

public interface CalculateStrategy {
    /**
     * 按距离来计算价格
     * @param km
     * @return
     */
    int calculatePrice(int km);
}
