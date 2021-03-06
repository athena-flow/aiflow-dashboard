package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardOrderGoods;
import com.aiflow.dashboard.db.domain.DashboardOrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardOrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    long countByExample(DashboardOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int insert(DashboardOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int insertSelective(DashboardOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    DashboardOrderGoods selectOneByExample(DashboardOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    DashboardOrderGoods selectOneByExampleSelective(@Param("example") DashboardOrderGoodsExample example, @Param("selective") DashboardOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    List<DashboardOrderGoods> selectByExampleSelective(@Param("example") DashboardOrderGoodsExample example, @Param("selective") DashboardOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    List<DashboardOrderGoods> selectByExample(DashboardOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    DashboardOrderGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardOrderGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    DashboardOrderGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    DashboardOrderGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardOrderGoods record, @Param("example") DashboardOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardOrderGoods record, @Param("example") DashboardOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}