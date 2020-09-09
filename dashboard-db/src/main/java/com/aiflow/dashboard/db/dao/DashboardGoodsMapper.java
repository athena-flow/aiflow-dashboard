package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardGoods;
import com.aiflow.dashboard.db.domain.DashboardGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    long countByExample(DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int insert(DashboardGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int insertSelective(DashboardGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    DashboardGoods selectOneByExample(DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    DashboardGoods selectOneByExampleSelective(@Param("example") DashboardGoodsExample example, @Param("selective") DashboardGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    DashboardGoods selectOneByExampleWithBLOBs(DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    List<DashboardGoods> selectByExampleSelective(@Param("example") DashboardGoodsExample example, @Param("selective") DashboardGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    List<DashboardGoods> selectByExampleWithBLOBs(DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    List<DashboardGoods> selectByExample(DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    DashboardGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardGoods.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    DashboardGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    DashboardGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardGoods record, @Param("example") DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") DashboardGoods record, @Param("example") DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardGoods record, @Param("example") DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(DashboardGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}