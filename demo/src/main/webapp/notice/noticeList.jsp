<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.*" %> <% 
//include를 통해
//jsp와 bootstrap이 함께 하나로 합쳐짐. //서블릿(FrontMVC)을
//경유[NoticeController-> NoticeLogic]하고 //select한 결과를 돌려(List<Map
//  >) 받아서 request객체에 담아 두었다 // req.setAttribute("xList", nList);
  int size = 0;
  List<Map<String,Object>> nList = (List)request.getAttribute("nList"); 
  if(nList!=null){
	  size=nList.size();
  }
  out.print(size); 
  //테스트 링크
  //http://localhost:8000/notice/noticeList.jsp -> 0 나옴(난 왜 널이 나오지??)
  //http://localhost:8000/notice/noticeList.gd -> 오라클 거쳐서 나옴 
  
  %>
    <!DOCTYPE html>
    <html lang="ko">
      <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>공지사항{webapp}</title>
        <%@ include file="/common/bootstrap_common.jsp" %>
        <link rel="stylesheet" href="/css/notice.css" />
        <script type="text/javascript">
          function searchEnter() {
            console.log("searchEnter");
          }
          function noticeSearch() {
            console.log("noticeSearch");
          }
        </script>
      </head>
      <body>
        <!-- 공지사항 목록 처리할 코드 작성해 보기 -->

        <div class="container">
          <div class="page-header">
            <h2>공지사항 <small>공지목록</small></h2>
            <hr />
          </div>
          <!-- 검색기 시작 -->
          <div class="row">
            <div class="col-3">
              <select id="gubun" class="form-select" aria-label="분류선택">
                <option value="none">분류선택</option>
                <option value="n_title">제목</option>
                <option value="n_writer">작성자</option>
                <option value="n_content">내용</option>
              </select>
            </div>
            <div class="col-6">
              <input
                type="text"
                id="keyword"
                class="form-control"
                placeholder="검색어를 입력하세요"
                aria-label="검색어를 입력하세요"
                aria-describedby="btn_search"
                onkeyup="searchEnter()"
              />
            </div>
            <div class="col-3">
              <button
                id="btn_search"
                class="btn btn-danger"
                onClick="noticeSearch()"
              >
                검색
              </button>
            </div>
          </div>
          <!-- 검색기 끝 -->

          <!-- 회원목록 시작 -->
          <div class="notice-list">
            <table class="table table-hover">
              <thead>
                <tr>
                  <th width="10%">#</th>
                  <th width="50%">제목</th>
                  <th width="20%">작성자</th>
                </tr>
              </thead>
              <tbody>
<% //스크립틀릿 - 지변이다, 이곳은 메소드선언, 생성자 선언 불가!
   for(int i=0;i<size;i++){
	   Map<String, Object> rmap = nList.get(i);
   
%>
				<tr>
					<td><%=rmap.get("N_NO") %></td>
					<td><%=rmap.get("N_TITLE") %></td>
					<td><%=rmap.get("N_WRITER") %></td>
				</tr>
<%
   }
%>
              </tbody>
            </table>

            <!-- [[ 페이징 처리  구간  ]] -->

            <!-- [[ 페이징 처리  구간  ]] -->

            <div class="notice-footer">
              <button class="btn btn-warning" onclick="noticeList()">
                전체조회</button
              >&nbsp;
              <button
                type="button"
                class="btn btn-success"
                data-bs-toggle="modal"
                data-bs-target="#noticeForm"
              >
                글쓰기
              </button>
            </div>
          </div>
          <!-- 회원목록   끝  -->
        </div>
        <!-- body end       -->
        <!-- footer start -->

        <!-- footer end    -->
        <!-- ========================== [[ 공지사항 Modal ]] ========================== -->
        <div class="modal" id="noticeForm">
          <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
              <!-- Modal Header -->
              <div class="modal-header">
                <h4 class="modal-title">공지사항</h4>
                <button
                  type="button"
                  class="btn-close"
                  data-bs-dismiss="modal"
                ></button>
              </div>
              <!-- Modal body -->
              <div class="modal-body">
                <form id="f_notice" method="get" action="./noticeInsert.pj1">
                  <input type="hidden" name="method" value="memberInsert" />
                  <div class="form-floating mb-3 mt-3">
                    <input
                      type="text"
                      class="form-control"
                      id="n_title"
                      name="n_title"
                      placeholder="Enter 제목"
                    />
                    <label for="n_title">제목</label>
                  </div>
                  <div class="form-floating mb-3 mt-3">
                    <input
                      type="text"
                      class="form-control"
                      id="n_writer"
                      name="n_writer"
                      placeholder="Enter 작성자"
                    />
                    <label for="n_writer">작성자</label>
                  </div>
                  <div class="form-floating mb-3 mt-3">
                    <textarea
                      rows="5"
                      class="form-control h-25"
                      aria-label="With textarea"
                      id="n_content"
                      name="n_content"
                    ></textarea>
                  </div>
                </form>
              </div>
              <div class="modal-footer">
                <input
                  type="button"
                  class="btn btn-warning"
                  data-bs-dismiss="modal"
                  onclick="noticeInsert()"
                  value="저장"
                />
                <input
                  type="button"
                  class="btn btn-danger"
                  data-bs-dismiss="modal"
                  value="닫기"
                />
              </div>
            </div>
          </div>
        </div>
        <!-- ========================== [[ 공지사항 Modal ]] ========================== -->
      </body>
    </html>
