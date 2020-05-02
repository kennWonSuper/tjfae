package com.ruoyi.project.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.system.domain.vo.CheckVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.mapper.TOrgInfoMapper;
import com.ruoyi.project.system.domain.TOrgInfo;
import com.ruoyi.project.system.service.ITOrgInfoService;

/**
 * 部门Service业务层处理
 *
 * @author ruoyi
 * @date 2020-04-14
 */
@Service
public class TOrgInfoServiceImpl implements ITOrgInfoService
{
    @Autowired
    private TOrgInfoMapper tOrgInfoMapper;

    /**
     * 查询部门
     *
     * @param deptId 部门ID
     * @return 部门
     */
    @Override
    public TOrgInfo selectTOrgInfoById(Long deptId)
    {
        return tOrgInfoMapper.selectTOrgInfoById(deptId);
    }

    /**
     * 查询部门列表
     *
     * @param tOrgInfo 部门
     * @return 部门
     */
    @Override
    public List<TOrgInfo> selectTOrgInfoList(TOrgInfo tOrgInfo)
    {
        return tOrgInfoMapper.selectTOrgInfoList(tOrgInfo);
    }

    /**
     * 新增部门
     *
     * @param tOrgInfo 部门
     * @return 结果
     */
    @Override
    public int insertTOrgInfo(TOrgInfo tOrgInfo)
    {
        tOrgInfo.setCreateTime(DateUtils.getNowDate());
        return tOrgInfoMapper.insertTOrgInfo(tOrgInfo);
    }

    /**
     * 修改部门
     *
     * @param tOrgInfo 部门
     * @return 结果
     */
    @Override
    public int updateTOrgInfo(TOrgInfo tOrgInfo)
    {
        tOrgInfo.setUpdateTime(DateUtils.getNowDate());
        return tOrgInfoMapper.updateTOrgInfo(tOrgInfo);
    }

    /**
     * 批量删除部门
     *
     * @param deptIds 需要删除的部门ID
     * @return 结果
     */
    @Override
    public int deleteTOrgInfoByIds(Long[] deptIds)
    {
        return tOrgInfoMapper.deleteTOrgInfoByIds(deptIds);
    }

    /**
     * 删除部门信息
     *
     * @param deptId 部门ID
     * @return 结果
     */
    @Override
    public int deleteTOrgInfoById(Long deptId)
    {
        return tOrgInfoMapper.deleteTOrgInfoById(deptId);
    }

    @Override
    public int check(CheckVo checkVo) {

        return tOrgInfoMapper.check(checkVo);
    }
}
