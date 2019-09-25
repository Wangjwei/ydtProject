package cc.edt.frame.common.controller;

import cc.edt.frame.common.constant.CommonConstant;
import cc.edt.frame.common.constant.DictionaryConstant;
import cc.edt.frame.model.result.ActionResult;
import cc.edt.iceutils2.date.IceDateFormatUtils;
import cc.edt.iceutils2.random.IceRandomUtils;
import cc.edt.iceutils2.string.IceStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件上传
 *
 * @author 刘钢 2017/12/18 10:41
 */
@Controller
@RequestMapping("upload")
public class UploadController extends BaseController {


	/**
	 * 文件上传方法
	 *
	 * @param file
	 *            file
	 * @author 刘钢
	 * @date 2017/5/28 23:29
	 */
	@RequestMapping("uploadFileAction")
	@ResponseBody
	public void uploadFile(@RequestParam("file") MultipartFile file) {
		ActionResult actionResult = new ActionResult();
		// 文件后缀
		String fileMark = IceStringUtils.substring(file.getOriginalFilename(),
				IceStringUtils.lastIndexOf(file.getOriginalFilename(), "."));
		// 文件名称
		String fileName = IceRandomUtils.longUUID();
		// 文件目录
		String fileDir = IceDateFormatUtils.getNowDateTime("yyyyMMdd");
		// 文件磁盘
		String fileDisk = DictionaryConstant.UPLOAD_PATH_DISK;
		// 文件全路径
		String filePath = fileDisk + "/" + fileDir + "/" + fileName + fileMark;

		File saveFile = new File(filePath);
		if (!saveFile.getParentFile().exists()) {
			boolean isDel = saveFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(saveFile);
			actionResult.setSuccess(true);
			actionResult.setResultList(fileDir + "/" + fileName + fileMark);
			writerToPageByJson(actionResult);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * UE文件上传方法
	 *
	 * @param file
	 *            file
	 * @author 刘钢
	 * @date 2017/5/28 23:31
	 */
	@RequestMapping("uploadUEFile")
	@ResponseBody
	public void uploadUEFile(@RequestParam("file") MultipartFile file) {
		// 文件后缀
		String fileMark = IceStringUtils.substring(file.getOriginalFilename(),
				IceStringUtils.lastIndexOf(file.getOriginalFilename(), "."));
		// 文件名称
		String fileName = IceRandomUtils.longUUID();
		// 文件目录
		String fileDir = IceDateFormatUtils.getNowDateTime("yyyyMMdd");
		// 文件磁盘
		String fileDisk = DictionaryConstant.UPLOAD_PATH_DISK;
		// 文件全路径
		String filePath = fileDisk + "/" + fileDir + "/" + fileName + fileMark;
		Map<String, Object> params = new HashMap<>();
		File saveFile = new File(filePath);
		if (!saveFile.getParentFile().exists()) {
			boolean isDel = saveFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(saveFile);
			params.put("state", "SUCCESS");
			params.put("url", DictionaryConstant.UPLOAD_PATH_WEB + "/" + fileDir
					+ "/" + fileName + fileMark);
			params.put("size", file.getSize());
			params.put("original", fileName + fileMark);
			params.put("type", file.getContentType());
			writerToPageByJson(params);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}
}
