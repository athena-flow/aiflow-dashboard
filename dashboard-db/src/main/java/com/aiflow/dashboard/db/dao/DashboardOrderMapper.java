package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardOrder;
import com.aiflow.dashboard.db.domain.DashboardOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    long countByExample(DashboardOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int insert(DashboardOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int insertSelective(DashboardOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    DashboardOrder selectOneByExample(DashboardOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    DashboardOrder selectOneByExampleSelective(@Param("example") DashboardOrderExample example, @Param("selective") DashboardOrder.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    List<DashboardOrder> selectByExampleSelective(@Param("example") DashboardOrderExample example, @Param("selective") DashboardOrder.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    List<DashboardOrder> selectByExample(DashboardOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    DashboardOrder selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardOrder.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    DashboardOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    DashboardOrder selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardOrder record, @Param("example") DashboardOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardOrder record, @Param("example") DashboardOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_order
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}