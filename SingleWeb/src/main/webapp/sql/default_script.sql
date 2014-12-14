/*
 * 계정관련 스크립트
 * DEFAULT ID/PASSWORD : SINGLEUSER / SINGLE
 */
CREATE USER SINGLEUSER IDENTIFIED BY SINGLE; -- 계정생성 및 비밀번호
GRANT RESOURCE , CONNECT , DBA TO SINGLEUSER; -- 권한
DROP USER SINGLEUSER CASCADE; -- 계정 삭제

/*
 * 테이블 스페이스 관련 스크립트
 */
-- 전체조회
SELECT * FROM DBA_TABLESPACES;

-- 테이블스페이스별 용량 확인 쿼리문(MB 단위)
select   substr(a.tablespace_name,1,30) tablespace,
         round(sum(a.total1)/1024/1024,1) "TotalMB",
         round(sum(a.total1)/1024/1024,1)-round(sum(a.sum1)/1024/1024,1) "UsedMB",
         round(sum(a.sum1)/1024/1024,1) "FreeMB",
         round((round(sum(a.total1)/1024/1024,1)-round(sum(a.sum1)/1024/1024,1))/round(sum(a.total1)/1024/1024,1)*100,2) "Used%"
from
         (select   tablespace_name,0 total1,sum(bytes) sum1,max(bytes) MAXB,count(bytes) cnt
          from     dba_free_space
          group by tablespace_name
          union
          select   tablespace_name,sum(bytes) total1,0,0,0
          from     dba_data_files
          group by tablespace_name) a
group by a.tablespace_name
order by tablespace;

