package com.webank.webase.chain.mgr.repository.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import com.webank.webase.chain.mgr.node.entity.NodeParam;
import com.webank.webase.chain.mgr.repository.bean.TbNode;

public interface TbNodeMapper {

    @SelectProvider(type = TbNodeSqlProvider.class, method = "countByParam")
    public int countByParam(NodeParam param);

    @SelectProvider(type = TbNodeSqlProvider.class, method = "selectByParam")
    public List<TbNode> selectByParam(NodeParam param);

    @Select({ "select * from tb_node where node_id = #{nodeId}" })
    TbNode getByNodeId(@Param("nodeId") String nodeId);

    @UpdateProvider(type = TbNodeSqlProvider.class, method = "update")
    int update(TbNode tbNode);

    @Delete({ "delete from tb_node where node_id=#{nodeId} and group_id = #{groupId}" })
    int deleteByNodeIdAndGroupId(@Param("nodeId") String nodeId, @Param("groupId") int groupId);

    @Delete({ "delete from tb_node where chain_id=#{chainId} and group_id = #{groupId}" })
    int deleteByChainIdAndGroupId(@Param("chainId") int chainId, @Param("groupId") int groupId);

    @Delete({ "delete from tb_node where chain_id=#{chainId}" })
    int deleteByChainId(@Param("chainId") int chainId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_node
     *
     * @mbg.generated
     */
    @Delete({ "delete from tb_node", "where node_id = #{nodeId,jdbcType=VARCHAR}", "and chain_id = #{chainId,jdbcType=INTEGER}", "and group_id = #{groupId,jdbcType=INTEGER}" })
    int deleteByPrimaryKey(@Param("nodeId") String nodeId, @Param("chainId") Integer chainId, @Param("groupId") Integer groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_node
     *
     * @mbg.generated
     */
    @InsertProvider(type = TbNodeSqlProvider.class, method = "insertSelective")
    int insertSelective(TbNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_node
     *
     * @mbg.generated
     */
    @Select({ "select", "node_id, chain_id, group_id, node_name, node_ip, p2p_port, block_number, pbft_view, ", "node_active, description, create_time, modify_time", "from tb_node", "where node_id = #{nodeId,jdbcType=VARCHAR}", "and chain_id = #{chainId,jdbcType=INTEGER}", "and group_id = #{groupId,jdbcType=INTEGER}" })
    @Results({ @Result(column = "node_id", property = "nodeId", jdbcType = JdbcType.VARCHAR, id = true), @Result(column = "chain_id", property = "chainId", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "group_id", property = "groupId", jdbcType = JdbcType.INTEGER, id = true), @Result(column = "node_name", property = "nodeName", jdbcType = JdbcType.VARCHAR), @Result(column = "node_ip", property = "nodeIp", jdbcType = JdbcType.VARCHAR), @Result(column = "p2p_port", property = "p2pPort", jdbcType = JdbcType.INTEGER), @Result(column = "block_number", property = "blockNumber", jdbcType = JdbcType.BIGINT), @Result(column = "pbft_view", property = "pbftView", jdbcType = JdbcType.BIGINT), @Result(column = "node_active", property = "nodeActive", jdbcType = JdbcType.TINYINT), @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR), @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP), @Result(column = "modify_time", property = "modifyTime", jdbcType = JdbcType.TIMESTAMP) })
    TbNode selectByPrimaryKey(@Param("nodeId") String nodeId, @Param("chainId") Integer chainId, @Param("groupId") Integer groupId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_node
     *
     * @mbg.generated
     */
    @UpdateProvider(type = TbNodeSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TbNode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_node
     *
     * @mbg.generated
     */
    @Insert({ "<script>", "insert into tb_node (node_id, ", "chain_id, group_id, ", "node_name, node_ip, ", "p2p_port, block_number, ", "pbft_view, node_active, ", "description, create_time, ", "modify_time)", "values<foreach collection=\"list\" item=\"detail\" index=\"index\" separator=\",\">(#{detail.nodeId,jdbcType=VARCHAR}, ", "#{detail.chainId,jdbcType=INTEGER}, #{detail.groupId,jdbcType=INTEGER}, ", "#{detail.nodeName,jdbcType=VARCHAR}, #{detail.nodeIp,jdbcType=VARCHAR}, ", "#{detail.p2pPort,jdbcType=INTEGER}, #{detail.blockNumber,jdbcType=BIGINT}, ", "#{detail.pbftView,jdbcType=BIGINT}, #{detail.nodeActive,jdbcType=TINYINT}, ", "#{detail.description,jdbcType=VARCHAR}, #{detail.createTime,jdbcType=TIMESTAMP}, ", "#{detail.modifyTime,jdbcType=TIMESTAMP})</foreach></script>" })
    int batchInsert(java.util.List<TbNode> list);
}