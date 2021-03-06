package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardRole;
import com.aiflow.dashboard.db.domain.DashboardRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    long countByExample(DashboardRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int insert(DashboardRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int insertSelective(DashboardRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    DashboardRole selectOneByExample(DashboardRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    DashboardRole selectOneByExampleSelective(@Param("example") DashboardRoleExample example, @Param("selective") DashboardRole.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    List<DashboardRole> selectByExampleSelective(@Param("example") DashboardRoleExample example, @Param("selective") DashboardRole.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    List<DashboardRole> selectByExample(DashboardRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    DashboardRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardRole.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    DashboardRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    DashboardRole selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardRole record, @Param("example") DashboardRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardRole record, @Param("example") DashboardRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_role
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}