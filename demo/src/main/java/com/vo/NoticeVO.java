package com.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter //get메소드와 set메소드를 생성할 필요없이 어노테이션을 쓰면 사용이 가능하다. 
//@Setter
@Data
@NoArgsConstructor //매개변수가 없는 기본 생성자를 생성한다.
//@AllArgsConstructor //모든 필드에 대한 생성자를 만들어준다. 마찬가지로 의존성을 주입받을 수 있다.
public class NoticeVO {
	private int n_no = 0;
	private String n_title = null;
	private String n_content = null;
	private String n_writer = null;
	@Builder
	public NoticeVO(int n_no, String n_title, String n_content, String n_writer) {
		super();
		this.n_no = n_no;
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_writer = n_writer;
	}
}
