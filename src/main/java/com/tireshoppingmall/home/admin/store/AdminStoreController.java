package com.tireshoppingmall.home.admin.store;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminStoreController {

	@Autowired
	private BranchDAO bDAO;

	// admin.company.go
	@RequestMapping(value = "/admin.store.go", method = RequestMethod.GET)
	public String companyGo(Model m, HttpServletRequest req) {
		req.setAttribute("contentPage", "store/branch.jsp");
		bDAO.getAllBranch(m);
		return "admin/master";
	}

	@RequestMapping(value = "/admin.store.reg.go", method = RequestMethod.GET)
	public String storeRegGo(Model m, HttpServletRequest req) {

		return "admin/store/regbranch";

	}

	@RequestMapping(value = "/reg.branch.do", method = RequestMethod.GET)
	public String storeRegDo(BranchDTO b, HttpServletRequest req) {

		bDAO.regBranch(b, req);
		return "admin/store/regbranch";

	}

	@RequestMapping(value = "/branch.search.branchname", method = RequestMethod.GET)
	public String branchSearchbranchname(BranchDTO b, Model m, HttpServletRequest req) {
		bDAO.branchSearchbranchname(b, m);
		req.setAttribute("contentPage", "store/branch.jsp");
		return "admin/master";

	}

	@RequestMapping(value = "/admin.store.update.go", method = RequestMethod.GET)
	public String branchupdateGo(BranchDTO b, Model m, HttpServletRequest req) {
		bDAO.getbranch(b, req);
		return "admin/store/updatebranch";

	}

	@RequestMapping(value = "/admin.store.update.do", method = RequestMethod.GET)
	public String branchupdateDo(BranchDTO b, Model m, HttpServletRequest req) {

		bDAO.updatebranch(b, req);
		bDAO.getbranch(b, req);
		bDAO.getAllBranch(m);

		return "admin/master";

	}

	@RequestMapping(value = "/admin.store.delete.go", method = RequestMethod.GET)
	public String branchdelete(BranchDTO b, Model m, HttpServletRequest req) {

		bDAO.deletebranch(b, req);
		bDAO.getAllBranch(m);

		req.setAttribute("contentPage", "store/branch.jsp");
		return "admin/master";

	}

}
