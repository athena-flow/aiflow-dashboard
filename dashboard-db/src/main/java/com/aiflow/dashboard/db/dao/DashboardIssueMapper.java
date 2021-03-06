package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardIssue;
import com.aiflow.dashboard.db.domain.DashboardIssueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardIssueMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    long countByExample(DashboardIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int insert(DashboardIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int insertSelective(DashboardIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    DashboardIssue selectOneByExample(DashboardIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    DashboardIssue selectOneByExampleSelective(@Param("example") DashboardIssueExample example, @Param("selective") DashboardIssue.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    List<DashboardIssue> selectByExampleSelective(@Param("example") DashboardIssueExample example, @Param("selective") DashboardIssue.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    List<DashboardIssue> selectByExample(DashboardIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    DashboardIssue selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardIssue.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    DashboardIssue selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    DashboardIssue selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardIssue record, @Param("example") DashboardIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardIssue record, @Param("example") DashboardIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardIssue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardIssueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_issue
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}