package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardLog;
import com.aiflow.dashboard.db.domain.DashboardLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    long countByExample(DashboardLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int insert(DashboardLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int insertSelective(DashboardLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    DashboardLog selectOneByExample(DashboardLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    DashboardLog selectOneByExampleSelective(@Param("example") DashboardLogExample example, @Param("selective") DashboardLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    List<DashboardLog> selectByExampleSelective(@Param("example") DashboardLogExample example, @Param("selective") DashboardLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    List<DashboardLog> selectByExample(DashboardLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    DashboardLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardLog.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    DashboardLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    DashboardLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardLog record, @Param("example") DashboardLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardLog record, @Param("example") DashboardLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_log
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}