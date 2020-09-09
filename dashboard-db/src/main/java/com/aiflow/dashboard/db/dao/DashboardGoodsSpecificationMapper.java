package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardGoodsSpecification;
import com.aiflow.dashboard.db.domain.DashboardGoodsSpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardGoodsSpecificationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    long countByExample(DashboardGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int insert(DashboardGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int insertSelective(DashboardGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    DashboardGoodsSpecification selectOneByExample(DashboardGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    DashboardGoodsSpecification selectOneByExampleSelective(@Param("example") DashboardGoodsSpecificationExample example, @Param("selective") DashboardGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    List<DashboardGoodsSpecification> selectByExampleSelective(@Param("example") DashboardGoodsSpecificationExample example, @Param("selective") DashboardGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    List<DashboardGoodsSpecification> selectByExample(DashboardGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    DashboardGoodsSpecification selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardGoodsSpecification.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    DashboardGoodsSpecification selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    DashboardGoodsSpecification selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardGoodsSpecification record, @Param("example") DashboardGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardGoodsSpecification record, @Param("example") DashboardGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardGoodsSpecification record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardGoodsSpecificationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_goods_specification
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}