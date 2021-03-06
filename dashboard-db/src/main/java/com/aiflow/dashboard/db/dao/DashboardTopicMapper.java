package com.aiflow.dashboard.db.dao;

import com.aiflow.dashboard.db.domain.DashboardTopic;
import com.aiflow.dashboard.db.domain.DashboardTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DashboardTopicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    long countByExample(DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int deleteByExample(DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int insert(DashboardTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int insertSelective(DashboardTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    DashboardTopic selectOneByExample(DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    DashboardTopic selectOneByExampleSelective(@Param("example") DashboardTopicExample example, @Param("selective") DashboardTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    DashboardTopic selectOneByExampleWithBLOBs(DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    List<DashboardTopic> selectByExampleSelective(@Param("example") DashboardTopicExample example, @Param("selective") DashboardTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    List<DashboardTopic> selectByExampleWithBLOBs(DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    List<DashboardTopic> selectByExample(DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    DashboardTopic selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") DashboardTopic.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    DashboardTopic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    DashboardTopic selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") DashboardTopic record, @Param("example") DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") DashboardTopic record, @Param("example") DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") DashboardTopic record, @Param("example") DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(DashboardTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(DashboardTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(DashboardTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") DashboardTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dashboard_topic
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}