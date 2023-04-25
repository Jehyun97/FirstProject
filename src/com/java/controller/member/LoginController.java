package com.java.controller.member;

import java.util.List;
import java.util.Map;

import com.java.attribute.Session;
import com.java.command.Criteria;
import com.java.controller.Controller;
import com.java.controller.MainController;
import com.java.dto.member.MemberVO;
import com.java.service.member.MemberService;
import com.java.service.member.MemberServiceImpl;
import com.java.views.View;
import com.java.views.member.LoginFormView;

public class LoginController extends Controller {

	private View view = new LoginFormView();
	private MemberService memberService = new MemberServiceImpl();
	
	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		while (flag) {
			Criteria cri = new Criteria();
			cri.setKeyword("");
			cri.setSearchType("");

			Map<String, Object> dataMap = paramMap;
			List<MemberVO> memberList = null;
			
			Map<String, Object> paramData = view.view(null);

			
			
			
			flag = (Boolean) paramData.get("flag");
			if (!flag)
				// 종료 메뉴 선택 안한경우 계속
				break;

			String id = (String) paramData.get("id");
			Session session = new Session();

			switch ((int) paramData.get("menu")) {
			case 1:
				try {
					String pwd = (String) paramData.get("pwd");
					MemberVO member = memberService.getMember(id);
					if (member != null) { // 아이디 일치
						if (pwd.equals(member.getPwd())) { // 로그인성공

							// 메인 컨트롤러 호출
							System.out.println("로그인 성공");
							session = new Session();
							session.setAttribute("menu", "main"); //session 정보를 main으로 설정
							paramData.put("session",session);
							
							MainController mController = new MainController(member);
							mController.execute(paramData);

						} else { // 패스워드 불일치
							System.out.println("패스워드가 일치하지 않습니다.");
						}
					} else {// 아이디 불일치
						System.out.println("아이디가 일치하지 않습니다.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2: //회원가입
				
				System.out.println("test");
				try {
					MemberVO member = memberService.getMember(id);
					if (member == null) { // 아이디 중복이 아님
						System.out.println("아이디가 중복이 아닙니다");
						// 패스워드, 이름, 전화번호 받아야됨
						SignupController signupController = new SignupController();
						signupController.execute(paramData);
						
						
						
//						session = new Session();
//						session.setAttribute("menu", ""); // session을 멤버관리로 전환
//						dataMap.put("session", session);
						
						
						

					} else {// 아이디가 중복임
						System.out.println("중복된 아이디 입니다.");
					}

				} catch (Exception e) {
					e.printStackTrace();

				}
				break;

			}

		}

		return null;

	}

}
