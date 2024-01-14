package kr.co.chunjae.ex03;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/boards")
public class BoardController {
    static Logger logger = LoggerFactory.getLogger(BoardController.class);

    // Get 방식으로 요청하기 때문에 모든 글의 정보를 조회한다
    // -> 전체 글을 조회하히
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<ArticleVO> listArticles() {
        logger.info("listArticles 메소드 호출");
        List<ArticleVO> list = new ArrayList<ArticleVO>();

        for(int i=0; i<10; i++) {
            ArticleVO vo = new ArticleVO();
            vo.setArticleNo(i);
            vo.setWriter("홍길동" + i);
            vo.setTitle("테스트입니다" + i);
            vo.setContent("새 상품을 소개합니다" + i);
            list.add(vo);
        }
        return new ResponseEntity(list, HttpStatus.OK);
    }


    // Get 방식으로 요청하면서 글 번호를 전달하기 때문에, 글 번호에 대한 글 정보를 조회
    // -> 선택한 글에 대한 자료만 가져오기
    @RequestMapping(value = "/{articleNo}", method = RequestMethod.GET)
    public ResponseEntity<ArticleVO> findArticle(
            @PathVariable("articleNo") Integer articleNo) {
        logger.info("findArticle 메소드 호출");

        ArticleVO vo = new ArticleVO();
        vo.setArticleNo(articleNo);
        vo.setWriter("이자바");
        vo.setTitle("테스트 중입니다~");
        vo.setContent("이자바의 글입니다");

        return new ResponseEntity(vo, HttpStatus.OK);
    }


    // post 방식으로 요청하기 때문에
    // 요청이 들어오면 json으로 전달되는 객체를 새 글로 추가한다
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> addArticle(@RequestBody ArticleVO articleVo) {
        ResponseEntity<String> resEntity = null;
        try {
            logger.info("addArticle 메소드 호출");
            logger.info(articleVo.toString());
            resEntity = new ResponseEntity<String>("ADD_SUCCEEDED", HttpStatus.OK);
        } catch (Exception e) {
            resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return resEntity;
    }


    // put 방식으로 요청하기 때문에 articleNo에 대한 글을
    // json 방식으로 수정한다
    @RequestMapping(value = "/{articleNo}", method = RequestMethod.PUT)
    public ResponseEntity<String> modArticle(
            @PathVariable("articleNo")Integer articleNo, @RequestBody ArticleVO articleVo) {
        ResponseEntity<String> resEntity = null;
        try {
            logger.info("modArticle 메소드 호출");
            logger.info(articleVo.toString());
            resEntity = new ResponseEntity<String>("MOD_SECCEEDED", HttpStatus.OK);
        } catch (Exception e) {
            resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return resEntity;
    }


    // Delete 방식으로 요청하기 때문에
    // 전달되는 articleNo에 대한 글을 삭제할 수 있다
    @RequestMapping(value = "/{articleNo}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeArticle (@PathVariable("articleNo") Integer articleNo) {
        ResponseEntity<String> resEntity = null;
        try {
            logger.info("removeArticle 메서드 호출합니다");
            logger.info(articleNo.toString());
            resEntity = new ResponseEntity<String>("REMOVE_SECCEEDED", HttpStatus.OK);
        } catch (Exception e) {
            resEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return resEntity;
    }
}