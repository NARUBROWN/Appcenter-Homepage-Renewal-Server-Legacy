# Appcenter-Homepage-Renewal-Server
Incheon National University Appcenter Homepage Renewal Server

<h2>API 명세</h2>
<h4>role-controller (/roles)</h4>
역할 컨트롤러: 권한을 관리합니다. 파트원, 파트장, 센터장.. 같은 정보를 저장하고 관리합니다. <br><br>
GET /roles: 역할 (1개) 가져오기 <br>
POST /roles: 역할 (1개) 저장하기 <br>
DELETE /roles: 역할 (1개) 삭제하기 / 역할이 그룹에 등록되어 있으면 삭제되지 않습니다. <br>
PATCH /roles: 역할 (1개) 수정하기 / 수정된 역할은 그룹내 모든 구성원에게 영향을 미칩니다. <br>
GET /roles/all-roles: 역할 (전체) 가져오기  <br>

<h4> member-controller (/members) </h4>
동아리원 컨트롤러: 동아리원을 관리합니다. 이름, 소개, 프로필 URL.. 같은 정보를 저장하고 관리합니다.<br><br>
GET /members: 동아리원 (1명) 가져오기<br>
POST /members: 동아리원 (1명) 저장하기<br>
DELETE /members: 동아리원 (1명) 삭제하기 / 동아리원이 그룹에 등록되어 있으면 삭제되지 않습니다.<br>
PATCH /members: 동아리원 (1명) 수정하기 / 수정된 동아리원은 그룹에 영향을 미칩니다.<br>
GET /members/all-members: 동아리원 (전체) 가져오기<br>

<h4> group-controller (/group) </h4>
그룹 컨트롤러: 동아리 내 그룹(조직)을 관리합니다. 기수, 멤버, 역할... 같은 정보를 저장하고 관리합니다.<br><br>
GET /group: 그룹 멤버 (1명) 가져오기<br>
POST /group: 그룹 멤버 (1명) 저장하기<br>
DELETE /group: 그룹 멤버 (1명) 삭제하기 / 동아리원이 그룹에 등록되어 있으면 삭제되지 않습니다.<br>
⚠️ PATCH /group: 동아리원 (1명) 수정하기 / 수정된 동아리원은 그룹에 영향을 미칩니다.<br>
GET /group/all-groups-members: 동아리원 (전체) 가져오기<br>


<h2>⚠️ 참고 아티클 </h2>
[JPA query did not return a unique result 에러 해결방법] [https://velog.io/@mooh2jj/SpringBoot-File-uploaddownload-구현](https://wakestand.tistory.com/943) <br>
