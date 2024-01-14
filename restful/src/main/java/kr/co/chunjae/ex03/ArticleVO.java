package kr.co.chunjae.ex03;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleVO {
    private int articleNo;
    private String writer;
    private String title;
    private String content;

    public ArticleVO() {
    }

    public ArticleVO(int articleNo, String writer, String title, String content) {
        this.articleNo = articleNo;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        String info = "";
        info += "\n" + articleNo + "\n" + writer + "\n" + title + "\n" + content + "\n";
        return info;
    }

}