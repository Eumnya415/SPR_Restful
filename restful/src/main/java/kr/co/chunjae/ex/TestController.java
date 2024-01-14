package kr.co.chunjae.ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test/*") // /test 밑의 모든 것
public class TestController {

    // /hello로 요청 시 브라우저로 문자열을 전송하겠다
    @RequestMapping("/hello")
    public String hello() {
        return "Hello REST!!";
    }

    // MemberVO 객체의 속성 값을 저장한 후 JSON으로 전송할 것이다
    @RequestMapping("/member")
    public MemberVO member() {
        MemberVO vo = new MemberVO();
        vo.setId("lee");
        vo.setPwd("1234");
        vo.setName("이자바");
        vo.setEmail("java@test.com");
        return vo;
    }

    // 컬렉션(list)로 전달해서 json 배열로 (배열 요소는 vo의 자료)
    @RequestMapping("/membersList")
    public List<MemberVO> listMembers() {
        // MemberVO 객체를 저장할 ArrayList 객체를 생성한다
        List<MemberVO> list = new ArrayList<MemberVO>();

        // MemberVO 객체를 10개 생성해서 ArrayList에 저장
        for (int i = 0; i < 10; i++) {
            MemberVO vo = new MemberVO();
            vo.setId("lee" + i);
            vo.setPwd("1234" + i);
            vo.setName("이자바" + i);
            vo.setEmail("lee" + i + "@test.com");
            list.add(vo);
        }

        // ArrayList를 JSON으로 브라우저에 전송
        return list;
    }

        @RequestMapping("/membersMap")
        public Map<Integer, MemberVO> membersMap() {
            // MemberVO 객체를 저장할 HashMap 객체 생성
            Map<Integer, MemberVO> map = new HashMap<Integer, MemberVO>();

            // MemberVO 객체를 HashMap에 저장한다
            for (int i=0; i<10; i++) {
                MemberVO vo = new MemberVO();
                vo.setId("kim" + i);
                vo.setPwd("3456" + i);
                vo.setName("김길동" + i);
                vo.setEmail("kim" + i + "@test.com");
                map.put(i, vo);
            }
            return map;
        }

        static Logger logger = LoggerFactory.getLogger(TestController.class);

        @RequestMapping(value = "/info", method = RequestMethod.POST)
    // json으로 전송된 데이터를 MemberVO 객체의 속성에 자동으로 설정
    public void modify(@RequestBody MemberVO vo) {
        logger.info(vo.toString());
        }

    @RequestMapping("membersList2")
    public ResponseEntity<List<MemberVO>> listMembers2() {
        List<MemberVO> list = new ArrayList<MemberVO>();
        for(int i=0; i<10; i++) {
            MemberVO vo = new MemberVO();
            vo.setId("lee" + i);
            vo.setName("이자바" + i);
            vo.setPwd("2345" + i);
            vo.setEmail("lee" + i + "@test.com");
            list.add(vo);
        }
        // 오류코드 500으로 응답
        return new ResponseEntity(list, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/res3")
    public ResponseEntity res3() {
        HttpHeaders responseHeaders = new HttpHeaders();

        // 전송할 데이터의 종류와 인코딩을 설정
        responseHeaders.add("Content-Type", "text/html; charset=utf-8");

        // 전송할 자바 스크립트 코드를 문자열로 작성
        String message = "<script>";
        message += " alert('새 회원을 등록하겠습니다.' );";
        message += " location.href='/pro29/test/membersList2'; ";
        message += "</script>";

        // ResponseEntity를 이용해 Html 형식으로 전송
        return new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
    }


    }


