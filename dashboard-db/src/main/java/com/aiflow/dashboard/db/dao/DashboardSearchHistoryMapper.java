package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardSearchHistory;
import com.aiflow.dashboard.db.domain.DashboardSearchHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardSearchHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    long countByExample(DashboardSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int insert(DashboardSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int insertSelective(DashboardSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    DashboardSearchHistory selectOneByExample(DashboardSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    DashboardSearchHistory selectOneByExampleSelective(@Param("example") DashboardSearchHistoryExample example, @Param("selective") DashboardSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    List<DashboardSearchHistory> selectByExampleSelective(@Param("example") DashboardSearchHistoryExample example, @Param("selective") DashboardSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    List<DashboardSearchHistory> selectByExample(DashboardSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    DashboardSearchHistory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardSearchHistory.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    DashboardSearchHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    DashboardSearchHistory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardSearchHistory record, @Param("example") DashboardSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardSearchHistory record, @Param("example") DashboardSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardSearchHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardSearchHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_search_history
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}