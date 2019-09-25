package cc.edt.frame.base.service.impl;

import cc.edt.frame.base.dao.MenuDao;
import cc.edt.frame.base.service.MenuService;
import cc.edt.frame.model.entity.base.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单信息
 * 
 * @author 刘钢
 * @date 2018/1/12 14:44
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Resource
	private MenuDao menuDao;

	@Override
	public List<Menu> listMenu() {
		return menuDao.listMenu();
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveMenu(Menu menu) {
		menuDao.saveMenu(menu);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteAllMenu() {
		menuDao.deleteAllMenu();
	}

}
