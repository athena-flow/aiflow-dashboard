package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardPermission;
import com.aiflow.dashboard.db.domain.DashboardPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    long countByExample(DashboardPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int insert(DashboardPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int insertSelective(DashboardPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    DashboardPermission selectOneByExample(DashboardPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    DashboardPermission selectOneByExampleSelective(@Param("example") DashboardPermissionExample example, @Param("selective") DashboardPermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    List<DashboardPermission> selectByExampleSelective(@Param("example") DashboardPermissionExample example, @Param("selective") DashboardPermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    List<DashboardPermission> selectByExample(DashboardPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    DashboardPermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardPermission.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    DashboardPermission selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    DashboardPermission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardPermission record, @Param("example") DashboardPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardPermission record, @Param("example") DashboardPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_permission
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}