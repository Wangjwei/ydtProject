package cc.edt.frame.base.service.impl;

import cc.edt.frame.base.dao.RoleDao;
import cc.edt.frame.base.service.RoleService;
import cc.edt.frame.base.service.component.ActionResultService;
import cc.edt.frame.model.condition.FindCondition;
import cc.edt.frame.model.entity.base.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 刘钢
 * @date 2018/1/17 13:40
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;
    @Resource
    private ActionResultService actionResultService;

    @Override
    public List<Role> listRoleByCondition(FindCondition findCondition) {
        PageHelper.startPage(findCondition.getPage(), findCondition.getRows());
        List<Role> listRole = roleDao.listRoleByCondition(findCondition);
        PageInfo<Role> pageInfo = new PageInfo<>(listRole);
        findCondition.setTotalRows(pageInfo.getTotal());
        return listRole;
    }

    @Override
    public Role getRoleById(String id) {
        return roleDao.getRoleById(id);
    }
    @Override
    public Role getRoleByIdForRights(String id) {
        return roleDao.getRoleByIdForRights(id);
    }

    @Override
    public Role getRoleByIdForMenu(String id) {
        return roleDao.getRoleByIdForMenu(id);
    }
}
