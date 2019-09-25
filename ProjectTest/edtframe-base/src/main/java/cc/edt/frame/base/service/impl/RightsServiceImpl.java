package cc.edt.frame.base.service.impl;

import cc.edt.frame.base.dao.RightsDao;
import cc.edt.frame.base.service.RightsService;
import cc.edt.frame.model.entity.base.Rights;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限信息
 * 
 * @author 刘钢
 * @date 2018/6/21 10:25
 */
@Service
public class RightsServiceImpl implements RightsService {

	@Resource
	private RightsDao rightsDao;

	@Override
	public List<Rights> listRights() {
		return rightsDao.listRights();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveRights(Rights rights) {
		rightsDao.saveRights(rights);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteAllRights() {
		rightsDao.deleteAllRights();
	}

}
