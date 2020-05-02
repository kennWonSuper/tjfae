package com.ruoyi.project.system.mapper;

import java.util.List;
import com.ruoyi.project.system.domain.TOrgInfo;
import com.ruoyi.project.system.domain.vo.CheckVo;

/**
 * 部门Mapper接口
 *
 * @author ruoyi
 * @date 2020-04-14
 */
public interface TOrgInfoMapper
{
    /**
     * 查询部门
     *
     * @param deptId 部门ID
     * @return 部门
     */
    public TOrgInfo selectTOrgInfoById(Long deptId);

    /**
     * 查询部门列表
     *
     * @param tOrgInfo 部门
     * @return 部门集合
     */
    public List<TOrgInfo> selectTOrgInfoList(TOrgInfo tOrgInfo);

    /**
     * 新增部门
     *
     * @param tOrgInfo 部门
     * @return 结果
     */
    public int insertTOrgInfo(TOrgInfo tOrgInfo);

    /**
     * 修改部门
     *
     * @param tOrgInfo 部门
     * @return 结果
     */
    public int updateTOrgInfo(TOrgInfo tOrgInfo);

    /**
     * 删除部门
     *
     * @param deptId 部门ID
     * @return 结果
     */
    public int deleteTOrgInfoById(Long deptId);

    /**
     * 批量删除部门
     *
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTOrgInfoByIds(Long[] deptIds);

    int check(CheckVo checkVo);

}
