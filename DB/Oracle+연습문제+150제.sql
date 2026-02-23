-- 사원의 이름과 성 , 근무중인 부서번호와 부서명을 조회한다(교집합)
--SELECT *
--	FROM EMPLOYEES
--		 , DPARTMENTS
-- WHERE ~~~~ 


--최상위 직원의 모든 부하직원들의 사원번호,이름,상사사원번호를 계단식(계층식)으로 조회한다
	SELECT LEVEL
	     , EMPLOYEE_ID
		   , FIRST_NAME
		   , MANAGER_ID
		FROM EMPLOYEES
	 START WITH MANAGER_ID IS NULL --ROOT NODE지정.
 CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID; --상하관계를 명시(상위노드 기준으로작성: 상사의 사원번호는 부하직원의 상사번호와 같다.)	 

 -- 101번 사원의 모든 부하직원들의 사원번호, 이름, 상사사원번호 계층식으로 조회한다.
			SELECT LEVEL
					 , EMPLOYEE_ID
					 , FIRST_NAME
					 , MANAGER_ID
			  FROM EMPLOYEES
			 START WITH EMPLOYEE_ID = 101
		 CONNECT BY PRIOR EMPLOYEE_ID = MANAGER_ID;
 
 -- 206번 사원의 모든 상사직원들의 사원번호, 이름, 상사사원번호를 계층식으로 조회한다.
 			SELECT LEVEL
 					 , EMPLOYEE_ID
					 , FIRST_NAME
					 , MANAGER_ID
			  FROM EMPLOYEES
		   START WITH EMPLOYEE_ID = 206
		 CONNECT BY PRIOR MANAGER_ID = EMPLOYEE_ID --상하관계를 명시(상위노드 기준으로작성: 부하직원의 상사사원번호는 상사직원의 사원번호다)	 
		   ORDER BY LEVEL DESC;
-- 직무별 수행중인 사원의 수를 조회한다
SELECT JOB_ID
		 , COUNT(EMPLOYEE_ID)
	FROM EMPLOYEES
 GROUP BY JOB_ID;

-- 도시별 근무중인 사원의 수를 조회한다
SELECT J.JOB_TITLE 
		 , COUNT(E.EMPLOYEE_ID)
	FROM EMPLOYEES E
 INNER JOIN JOBS J
 		ON E.JOB_ID = J.JOB_ID 
 GROUP BY J.JOB_TITLE;

SELECT L.CITY
		 , COUNT(E.EMPLOYEE_ID)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 GROUP BY L.CITY;

-- 도시별, 부서별로 근무중인 사원의 수를 조회한다.
SELECT L.CITY
		 , D.DEPARTMENT_NAME
		 , COUNT(E.EMPLOYEE_ID)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 GROUP BY L.CITY,D.DEPARTMENT_NAME;
 		

-- 목적조인 + 그룹핑 사용하는경우
-- 주문 목록 (상품준비중: 3, 배송시작: 4, 배송중: 1, 배송완료: 40, 리뷰작성: 30, 리뷰작성가능: 3)


 SELECT EMPLOYEES.FIRST_NAME
 			, EMPLOYEES.LAST_NAME
 			, DEPARTMENTS.DEPARTMENT_ID
 			, DEPARTMENTS.DEPARTMENT_NAME
 	 FROM EMPLOYEES
 	INNER JOIN DEPARTMENTS
 		 ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID;
 
 --사원의 이름과 성 월급 수행중인 직무아이디 직무의 이름 직무별 최대월급을 조회한다
 
 SELECT E.LAST_NAME 
 			, E.FIRST_NAME 
 			,	E.SALARY 
 			,	J.JOB_ID 
 			,	J.JOB_TITLE 
 			,	J.MAX_SALARY 
 	 FROM EMPLOYEES E
 	INNER JOIN JOBS J
 		 ON E.JOB_ID = J.JOB_ID ;
 
 -- 사원의 이름,사원번호, 월급, 수행중인 직무의 이름,근무중인 부서의 이름을 조회한다.
 
SELECT *
	FROM EMPLOYEES e
	INNER JOIN DEPARTMENTS d
		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
		INNER JOIN JOBS J
		ON E.JOB_ID = J.JOB_ID ;
 
 
-- 사원의 사원번호, 이름 ,성 , 이메일과 근무중인 도시의 이름을 조회한다.
SELECT E.EMPLOYEE_ID 
		 , E.FIRST_NAME 
		 , E.LAST_NAME 
		 , E.EMAIL 
		 , L.CITY 
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 		
 		
 -- 모든 사원의 이름 , 상사의 사원번호, 상사의 사원명을 조회한다.
 
SELECT EMP.FIRST_NAME 
		 , MAN.DEPARTMENT_ID
		 , MAN.FIRST_NAME
	FROM EMPLOYEES EMP
 INNER JOIN EMPLOYEES MAN
 		ON MAN.EMPLOYEE_ID = EMP.MANAGER_ID ;
-- 사원이 수행중인 직무의 이름, 상사가 수행중인 직무의 이름을 조회한다.
SELECT EMP.FIRST_NAME 
		 , MAN.DEPARTMENT_ID
		 , MAN.FIRST_NAME
		 , EMP_J.JOB_TITLE 
		 , MAN_J.JOB_TITLE 
	FROM EMPLOYEES EMP
 INNER JOIN EMPLOYEES MAN
 		ON MAN.EMPLOYEE_ID = EMP.MANAGER_ID
 INNER JOIN JOBS EMP_J
 		ON EMP.JOB_ID = EMP_J.JOB_ID 
 INNER JOIN JOBS MAN_J
 		ON MAN.JOB_ID = MAN_J.JOB_ID ;
 		
 		
-- 1. 현재 시간을 조회한다.
SELECT SYSDATE
	FROM DUAL;

--ORACLE 전용 표준아님!! 오라클만가능 SYSDATE 하면 시간나옴!
SELECT *
	FROM DUAL;

SELECT SYSDATE -1 --   정수를 뺴면    -정수 일의 날짜가 나온다
	FROM DUAL
	
SELECT SYSDATE -3/24 -- 3시간전 24분의3 
	FROM DUAL;

SELECT SYSDATE - 1/24/60 -- 1분전
	FROM DUAL;

SELECT SYSDATE +50/24/60/60 -- 1초
		 , SYSDATE
	FROM DUAL;
-- 2. 현재 시간을 "연-월-일" 포멧으로 조회한다.

SELECT ADD_MONTHS(SYSDATE,2) --  월단위조회( +-)
	FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD-HH24')
		 , TO_CHAR(SYSDATE, 'HH24:MI:SS')
	FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYY')
		 , TO_CHAR(SYSDATE, 'MM')
		 , TO_CHAR(SYSDATE, 'D')
		 , TO_CHAR(SYSDATE, 'HH')--12시간 기준 시
		 , TO_CHAR(SYSDATE, 'HH24')-- 24시간 기준 시
		 , TO_CHAR(SYSDATE, 'MI')-- 월에서 써서 MI임
		 , TO_CHAR(SYSDATE, 'SS')
	FROM DUAL;

-- 3. 한 시간 전 시간을 "시:분:초" 포멧으로 조회한다.
SELECT TO_CHAR(SYSDATE -1/24, 'HH24:MI:SS')
	FROM DUAL;

--2월 12일 연습문제(ORCL전용)
--	'2026-02-12'텍스트를 날짜 타입으로 변경한다
SELECT TO_DATE('2026-02-12','YYYY-MM-DD')
	FROM DUAL;
--	'2026-02-12'기준으로 50일 이후 날짜를 조회한다.
SELECT TO_DATE('2026-02-12','YYYY-MM-DD') + 50
	FROM DUAL;
--	'2026-02-13'기준으로 3시간 이후의 날짜와 시간을 조회한다.
SELECT TO_DATE('2026-02-12','YYYY-MM-DD') + 27/24
	FROM DUAL;
--	'2026-02-12'기준으로 1일 후의 날짜만 조회한다.
SELECT TO_CHAR(TO_DATE('2026-02-12','YYYY-MM-DD') + 1, 'YYYY-MM-DD')
	FROM DUAL;
--	'2026-02-12'기준으로 3일후의 날짜와 시 만 조회한다.
SELECT TO_CHAR(TO_DATE('2026-02-12','YYYY-MM-DD') + 3, 'DD-HH24')
	FROM DUAL;
-- 4. EMPLOYEES 테이블의 모든 정보를 조회한다.
SELECT EMPLOYEE_ID
     , FIRST_NAME
     , LAST_NAME
     , EMAIL 
     , PHONE_NUMBER 
     , HIRE_DATE 
     , JOB_ID 
     , SALARY
     , COMMISSION_PCT 
     , MANAGER_ID 
     , DEPARTMENT_ID 
  FROM EMPLOYEES
-- 5. DEPARTMENTS 테이블의 모든 정보를 조회한다.
  SELECT DEPARTMENT_ID
  	   , DEPARTMENT_NAME
  	   , MANAGER_ID
  	   , LOCATION_ID
    FROM DEPARTMENTS
-- 6. JOBS 테이블의 모든 정보를 조회한다
    SELECT JOB_ID
    	
    FROM JOBS
-- 7. LOCATIONS 테이블의 모든 정보를 조회한다.
-- 8. COUNTRIES 테이블의 모든 정보를 조회한다.
-- 9. REGIONS 테이블의 모든 정보를 조회한다.
-- 10. JOB_HISTORY 테이블의 모든 정보를 조회한다.
-- 11. 90번 부서에서 근무하는 사원들의 모든 정보를 조회한다.
     SELECT EMPLOYEE_ID
   					EMPLOYEE_ID
						FIRST_NAME
						LAST_NAME
						EMAIL
						PHONE_NUMBER
						HIRE_DATE
						JOB_ID
						SALARY
						COMMISSION_PCT
						MANAGER_ID
						DEPARTMENT_ID
		   FROM EMPLOYEES
		   WHERE DEPARTMENT_ID = 90
		   
-- 12. 90번, 100번 부서에서 근무하는 사원들의 모든 정보를 조회한다.
		   SELECT EMPLOYEE_ID
		   				
							FIRST_NAME
							LAST_NAME
							EMAIL
							PHONE_NUMBER
							HIRE_DATE    
							JOB_ID
							SALARY
							COMMISSION_PCT
							MANAGER_ID
							DEPARTMENT_ID
		     FROM EMPLOYEES
		    WHERE DEPARTMENT_ID = 90
		       OR DEPARTMENT_ID = 100
-- 13. 100번 상사의 직속 부하직원의 모든 정보를 조회한다.
		       SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE MANAGER_ID =100
		       
-- 14. 직무 아이디가 AD_VP 인 사원의 모든 정보를 조회한다.
		        SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE JOB_ID ='AD_VP';
		       
		        
-- 15. 월급이 7000 이상인 사원의 모든 정보를 조회한다.
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE SALARY > 7000;
-- 16. 2005년 09월에 입사한 사원들의 모든 정보를 조회한다.
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE HIRE_DATE >= TO_DATE('2005-09-01','YYYY-MM-DD')
		          AND HIRE_DATE < TO_DATE('2005-10-01','YYYY-MM-DD');

--
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE HIRE_DATE BETWEEN TO_DATE('2005-09-01','YYYY-MM-DD') AND TO_DATE('2005-10-01','YYYY-MM-DD')-1;

-- 17. 111번 사원의 모든 정보를 조회한다.
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE EMPLOYEE_ID = 111;
-- 18. 인센티브를 안받는 사원들의 모든 정보를 조회한다.
-- 19. 인센티브를 받는 사원들의 모든 정보를 조회한다.
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE COMMISSION_PCT IS NOT NULL;
-- 20. 이름의 첫 글자가 'D' 인 사원들의 모든 정보를 조회한다.
	SELECT EMPLOYEE_ID
		   , FIRST_NAME
		   , LAST_NAME
		   , EMAIL
		   , PHONE_NUMBER
		   , HIRE_DATE    
		   , JOB_ID
		   , SALARY
		   , COMMISSION_PCT
		   , MANAGER_ID
		   , DEPARTMENT_ID
	  FROM EMPLOYEES
	 WHERE FIRST_NAME LIKE 'D%';
-- 21. 성의 마지막 글자가 'a' 인 사원들의 모든 정보를 조회한다.
	SELECT EMPLOYEE_ID
		   , FIRST_NAME
		   , LAST_NAME
		   , EMAIL
		   , PHONE_NUMBER
		   , HIRE_DATE    
		   , JOB_ID
		   , SALARY
		   , COMMISSION_PCT
		   , MANAGER_ID
		   , DEPARTMENT_ID
	  FROM EMPLOYEES
	 WHERE LAST_NAME LIKE '%a';
-- 22. 전화번호에 '.124.'이 포함된 사원들의 모든 정보를 조회한다.
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE PHONE_NUMBER LIKE '%.123.%';
-- 23. 직무 아이디가 'PU_CLERK'인 사원 중 연봉이 3000 이상인 사원들의 모든 정보를 조회한다.
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE JOB_ID = 'PU_CLERK'
						  AND SALARY >= 3000;

-- 24. 평균 연봉보다 많이 받는 사원들의 사원번호, 이름, 성, 연봉을 조회한다.
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, SALARY
		         FROM EMPLOYEES
		        WHERE SALARY > (SELECT AVG(SALARY)
		        									FROM EMPLOYEES);


-- 25. 평균 연봉보다 적게 받는 사원들의 사원번호, 연봉, 부서번호를 조회한다.
					 SELECT EMPLOYEE_ID
								, SALARY
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE SALARY < (SELECT AVG(SALARY)
		        									FROM EMPLOYEES);

-- 26. 가장 많은 연봉을 받는 사원의 사원번호, 이름, 연봉을 조회한다.
					SELECT MAX(SALARY)
				  		 , MAX(SALARY)
						FROM EMPLOYEES
					 WHERE JOB_ID = 'SA_REP';

-- 27. 이름이 4글자인 사원의 모든 정보를 조회한다.
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE FIRST_NAME LIKE '____%';

-- 28. 'SA_REP' 직무인 직원 중/ 가장 높은 연봉과 가장 낮은 연봉을 조회한다.
		SELECT MAX(SALARY)
				 , MIN(SALARY)
			FROM EMPLOYEES;
-- 29. 직원의 입사일자를 '연-월-일' 형태로 조회한다.
SELECT TO_CHAR(HIRE_DATE,'YYYY-MM-DD')
	FROM EMPLOYEES;
-- 30. 가장 늦게 입사한 사원의 모든 정보를 조회한다.
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		         WHERE HIRE_DATE = (SELECT MAX(HIRE_DATE)
		         												FROM EMPLOYEES);

-- 31. 가장 일찍 입사한/ 사원의 모든 정보를 조회한다.

	SELECT MIN(HIRE_DATE)
		FROM EMPLOYEES;
	
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE HIRE_DATE = (	SELECT MIN(HIRE_DATE)
																	FROM EMPLOYEES);
-- 32. 자신의 상사보다 더 많은 연봉을 받는 사원의 모든 정보를 조회한다.//
					SELECT EMPLOYEE_ID
	 						 , FIRST_NAME
							 , LAST_NAME
							 , EMAIL
							 , PHONE_NUMBER
							 , HIRE_DATE
							 , JOB_ID
							 , SALARY
							 , COMMISSION_PCT
							 , MANAGER_ID
							 , DEPARTMENT_ID
					  FROM EMPLOYEES e
					 WHERE SALARY > (SELECT SALARY
													   FROM EMPLOYEES ep
													  WHERE ep.EMPLOYEE_ID = e.MANAGER_ID );
-- 33. 자신의 상사보다 더 일찍 입사한 사원의 모든 정보를 조회한다.//
					  SELECT EMPLOYEE_ID
								 , FIRST_NAME
								 , LAST_NAME
								 , EMAIL
								 , PHONE_NUMBER
								 , HIRE_DATE
								 , JOB_ID
								 , SALARY
								 , COMMISSION_PCT
								 , MANAGER_ID
								 , DEPARTMENT_ID
							FROM EMPLOYEES e
						 WHERE HIRE_DATE < (SELECT HIRE_DATE
														      FROM EMPLOYEES ep
														     WHERE ep.EMPLOYEE_ID = e.MANAGER_ID );
					 
-- 34. 부서아이디별 평균 연봉을 조회한다.
					SELECT DEPARTMENT_ID
							 , AVG(SALARY)
						FROM EMPLOYEES
					 GROUP BY DEPARTMENT_ID;
-- 35. 직무아이디별 평균 연봉, 최고연봉, 최저연봉을 조회한다.
					SELECT JOB_ID
							 , AVG(SALARY)
							 , MAX(SALARY)
							 , MIN(SALARY)
						FROM EMPLOYEES
					 GROUP BY JOB_ID;
-- 36. 가장 많은 인센티브를 받는 사원의 모든 정보를 조회한다.
					 SELECT MAX(COMMISSION_PCT) 
					 	 FROM EMPLOYEES 
					 	 
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE COMMISSION_PCT = ( SELECT MAX(COMMISSION_PCT) 
					 	 													 FROM EMPLOYEES);
					 
-- 37. 가장 적은 인센티브를 받는 사원의 연봉과 인센티브를 조회한다.
					 SELECT MIN(COMMISSION_PCT)
					 	 FROM EMPLOYEES;

					 SELECT SALARY
								, COMMISSION_PCT
		         FROM EMPLOYEES
		        WHERE COMMISSION_PCT = (SELECT MIN(COMMISSION_PCT)
					 	 													FROM EMPLOYEES);
		         
					 
-- 38. 직무아이디별 사원의 수를 조회한다.
		SELECT COUNT(JOB_ID)
			FROM EMPLOYEES;
-- 39. 상사아이디별 부하직원의 수를 조회한다. 단, 부하직원이 2명 이하인 경우는 제외한다.
		SELECT MANAGER_ID
			   , COUNT(EMPLOYEE_ID)
			FROM EMPLOYEES
		 GROUP BY MANAGER_ID
		HAVING COUNT(EMPLOYEE_ID) > 2;

-- 40. 사원이 속한 부서의 /평균연봉보다 적게 받는 /사원의 모든 정보를 조회한다.//
			SELECT EMPLOYEE_ID   
					 , FIRST_NAME    
					 , LAST_NAME     
					 , EMAIL         
					 , PHONE_NUMBER  
					 , HIRE_DATE     
					 , JOB_ID        
					 , SALARY        
					 , COMMISSION_PCT
					 , MANAGER_ID    
					 , DEPARTMENT_ID 
				FROM EMPLOYEES e
			 WHERE SALARY < (SELECT AVG(SALARY)
							 				   FROM EMPLOYEES ep
							 				  WHERE e.DEPARTMENT_ID = ep.DEPARTMENT_ID 
							 			 GROUP BY DEPARTMENT_ID); 			

--[V] 41. 사원이 근무하는 부서명, 이름, 성을 조회한다.
SELECT D.DEPARTMENT_NAME
		 , E.FIRST_NAME
		 , E.LAST_NAME
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
	  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID;

--[V] 42. 가장 적은 연봉을 받는 사원/의 부서명, 이름, 성, 연봉, 부서장사원번호를 조회한다.
SELECT MIN(SALARY) 
	FROM EMPLOYEES

SELECT D.DEPARTMENT_NAME 
		 , E.FIRST_NAME 
		 , E.LAST_NAME 
		 , E.SALARY
		 , D.MANAGER_ID
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 WHERE E.SALARY = (SELECT MIN(SALARY) 
										 FROM EMPLOYEES);
-- 43. 상사사원번호를 중복없이 조회한다.
-- 44. 50번 부서의 부서장의 이름, 성, 연봉을 조회한다.

		SELECT MANAGER_ID
			FROM DEPARTMENTS
		 WHERE DEPARTMENT_ID = '50';
		
		SELECT FIRST_NAME 
				 , LAST_NAME
				 , SALARY
			FROM EMPLOYEES
		 WHERE EMPLOYEE_ID = (SELECT MANAGER_ID
														FROM DEPARTMENTS
													 WHERE DEPARTMENT_ID = 50);
			
-- 45. 부서명별 사원의 수를 조회한다.
SELECT D.DEPARTMENT_NAME
		 , COUNT(E.EMPLOYEE_ID)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME;
 
		
-- 46. 사원의 수가 가장 많은 부서명, 사원의 수를 조회한다.
-- 47. 사원이 없는 부서명을 조회한다.
			SELECT DEPARTMENT_NAME
			  FROM DEPARTMENTS
			 WHERE DEPARTMENT_ID NOT IN (SELECT DEPARTMENT_ID
			 						       						 FROM EMPLOYEES
			 						      						WHERE DEPARTMENT_ID IS NOT NULL);
		
-- 48. 직무가 변경된/ 사원의 모든 정보를 조회한다.
		SELECT START_DATE
				 , EMPLOYEE_ID
				 , END_DATE
				 , END_DATE
				 , DEPARTMENT_ID
		  FROM JOB_HISTORY
		 WHERE EMPLOYEE_ID IS NOT NULL;

					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE EMPLOYEE_ID IN (SELECT EMPLOYEE_ID
																	  FROM JOB_HISTORY
																	 WHERE EMPLOYEE_ID IS NOT NULL);

		
-- 49. 직무가 변경된적 없는 사원의 모든 정보를 조회한다.
				SELECT START_DATE
				 , EMPLOYEE_ID
				 , END_DATE
				 , JOB_ID
				 , DEPARTMENT_ID
		  FROM JOB_HISTORY
		 WHERE JOB_ID IS NULL;


					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
		         FROM EMPLOYEES
		        WHERE EMPLOYEE_ID NOT IN (SELECT EMPLOYEE_ID
																		FROM JOB_HISTORY);
					 
-- [V]50. 직무가 변경된 사원의/ 과거 직무명과 현재 직무명을 조회한다.DANGER
SELECT PAST_J.JOB_TITLE
		 , NOW_J.JOB_TITLE
	FROM EMPLOYEES e
 INNER JOIN JOB_HISTORY jh
 		ON E.JOB_ID = JH.JOB_ID
 INNER JOIN JOBS PAST_J
 		ON JH.JOB_ID = PAST_J.JOB_ID
 INNER JOIN JOBS NOW_J
 		ON E.JOB_ID = NOW_J.JOB_ID;
-- 51. 직무가 가장 많이 변경된 부서의 이름을 조회한다.
-- [V]52. 'Seattle' 에서 근무중인 사원의 이름, 성, 연봉, 부서명 을 조회한다.
SELECT E.FIRST_NAME 
		 , E.LAST_NAME 
		 , E.SALARY 
		 , D.DEPARTMENT_NAME 
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 WHERE L.CITY = 'Seattle';
-- [V]53. 'Seattle' 에서 근무하지 않는 모든 사원의 이름, 성, 연봉, 부서명, 도시를 조회한다.
SELECT E.FIRST_NAME 
		 , E.LAST_NAME 
		 , E.SALARY 
		 , D.DEPARTMENT_NAME 
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 WHERE L.CITY != 'Seattle';
-- 54. 근무중인 사원이 가장 많은 도시와 사원의 수를 조회한다.  
-- 55. 근무중인 사원이 없는 도시를 조회한다.
-- 56. 연봉이 7000 에서 12000 사이인 사원이 근무중인 도시를 조회한다.
					 SELECT EMPLOYEE_ID
								, SALARY
		         FROM EMPLOYEES
		         WHERE SALARY BETWEEN 7000 AND 12000;

						SELECT DEPARTMENT_ID
								 , DEPARTMENT_NAME
								 , MANAGER_ID
								 , LOCATION_ID
							FROM DEPARTMENTS
						 WHERE DEPARTMENT_ID IN (SELECT EMPLOYEE_ID
											         FROM EMPLOYEES
											        WHERE SALARY BETWEEN 7000 AND 12000);
						
						SELECT LOCATION_ID
								 , STREET_ADDRESS
								 , POSTAL_CODE
								 , CITY
								 , STATE_PROVINCE
								 , COUNTRY_ID
						FROM LOCATIONS
						WHERE LOCATION_ID IN (SELECT LOCATION_ID
														FROM DEPARTMENTS
													 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
																		         FROM EMPLOYEES
																		        WHERE SALARY BETWEEN 7000 AND 12000));



					
					 
-- 57. 'Seattle' 에서 근무중인 사원의 직무명을 중복없이 조회한다.
						
						SELECT JOB_ID
						  FROM EMPLOYEES
						 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
						 						 			 FROM DEPARTMENTS
						 						 			WHERE LOCATION_ID = (SELECT LOCATION_ID
									 						                       FROM LOCATIONS
									 						                      WHERE CITY = 'Seattle'));
						SELECT DISTINCT JOB_TITLE
						  FROM JOBS
						 WHERE JOB_ID IN (SELECT JOB_ID
						  					FROM EMPLOYEES
						 				   WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
						 						  					  	 FROM DEPARTMENTS
						 						 							  WHERE LOCATION_ID = (SELECT LOCATION_ID
						 						                        							 FROM LOCATIONS
						 						                      					      WHERE CITY = 'Seattle')));
-- 58. 사내의 최고연봉과 최저연봉의 차이를 조회한다.
						SELECT MAX(SALARY)-MIN(SALARY)
							FROM EMPLOYEES
						 GROUP BY MANAGER_ID;
-- 59. 이름이 'Renske' 인 사원의 연봉과 같은 연봉을 받는 사원의 모든 정보를 조회한다. 단, 'Renske' 사원은 조회에서 제외한다.
						SELECT EMPLOYEE_ID   
								 , FIRST_NAME    
								 , LAST_NAME     
								 , EMAIL         
								 , PHONE_NUMBER  
								 , HIRE_DATE     
								 , JOB_ID        
								 , SALARY        
								 , COMMISSION_PCT
								 , MANAGER_ID    
								 , DEPARTMENT_ID 
							  FROM EMPLOYEES
							 WHERE FIRST_NAME != 'Renske' AND SALARY = (SELECT SALARY
											 				   														FROM EMPLOYEES
											 				  													 WHERE FIRST_NAME = 'Renske');
						
-- 60. 회사 전체의 평균 연봉보다 많이 받는 사원들 중 이름에 'u' 가 포함된 사원과 동일한 부서에서 근무중인 사원들의 모든 정보를 조회한다.41
						SELECT DEPARTMENT_ID
						  FROM EMPLOYEES
						 WHERE FIRST_NAME LIKE '%u%'
						   								 AND SALARY > (SELECT AVG(SALARY)
						   				   											 FROM EMPLOYEES);   				   

							SELECT EMPLOYEE_ID   
									 , FIRST_NAME    
									 , LAST_NAME     
									 , EMAIL         
									 , PHONE_NUMBER  
									 , HIRE_DATE     
									 , JOB_ID        
									 , SALARY        
									 , COMMISSION_PCT
									 , MANAGER_ID    
									 , DEPARTMENT_ID 
								FROM EMPLOYEES
							 WHERE DEPARTMENT_ID IN (SELECT DISTINCT DEPARTMENT_ID
											  						   	 FROM EMPLOYEES
											 						  		WHERE FIRST_NAME LIKE '%u%'
																	    										AND SALARY > (SELECT AVG(SALARY)
																	   				    													FROM EMPLOYEES));
						
-- 61. 부서가 없는 국가명을 조회한다.
							SELECT LOCATION_ID
  							FROM DEPARTMENTS;  

							SELECT COUNTRY_ID
							  FROM LOCATIONS
							 WHERE LOCATION_ID IN (SELECT LOCATION_ID
												     					 FROM DEPARTMENTS);

							SELECT COUNTRY_NAME
							  FROM COUNTRIES
							 WHERE COUNTRY_ID NOT IN (SELECT COUNTRY_ID
							  													FROM LOCATIONS
							 						   						 WHERE LOCATION_ID IN (SELECT DISTINCT LOCATION_ID
												     						   											 FROM DEPARTMENTS));
							
-- 62. 'Europe' 에서 근무중인 사원들의 모든 정보를 조회한다.
							SELECT EMPLOYEE_ID
									 , FIRST_NAME
									 , LAST_NAME     
									 , EMAIL         
									 , PHONE_NUMBER  
									 , HIRE_DATE     
									 , JOB_ID        
									 , SALARY        
									 , COMMISSION_PCT
									 , MANAGER_ID    
									 , DEPARTMENT_ID 
							  FROM EMPLOYEES
							 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
															 					 FROM DEPARTMENTS
															 				  WHERE LOCATION_ID IN (SELECT LOCATION_ID 
																					 						 					FROM LOCATIONS
																					 						 				 WHERE COUNTRY_ID IN (SELECT COUNTRY_ID
																										 						 					    				FROM COUNTRIES
																										 						 					    			 WHERE REGION_ID = (SELECT REGION_ID
																															 						 					    					 			FROM REGIONS
 						 					    					 					  																												WHERE REGION_NAME = 'Europe'))));
-- 63. 'Europe' 에서 가장 많은 사원들이 있는 부서명을 조회한다.
-- 64. 대륙 별 사원의 수를 조회한다.
SELECT R.REGION_NAME
		 , COUNT(E.EMPLOYEE_ID)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 INNER JOIN COUNTRIES c
 		ON L.COUNTRY_ID = C.COUNTRY_ID
 INNER JOIN REGIONS r
 		ON C.REGION_ID = R.REGION_ID
 GROUP BY R.REGION_NAME;

-- 65. 연봉이 2500, 3500, 7000 이 아니며 직무이 SA_REP 이거나 ST_CLERK 인 사람들을 조회한다.
					 SELECT JOB_ID
								, SALARY
		         FROM EMPLOYEES
		        WHERE (JOB_ID = 'SA_REP'
						  OR JOB_ID = 'ST_CLERK')
						  AND SALARY != 2500
						  AND SALARY != 3500
						  AND SALARY != 7000;
--월급이 2500, 3500, 7000 이 아닌 사원들의 사원번호와 월급을 조회한다
	 				 SELECT EMPLOYEE_ID
								, SALARY
		         FROM EMPLOYEES
		        WHERE SALARY NOT IN (2500,3500,7000);

--직무 아이디가 SA_REP 이거나 ST_CLERK 인 사원들의 사원번호와 직무아이디를 조회한다.
 					SELECT EMPLOYEE_ID
								, JOB_ID
		         FROM EMPLOYEES
		        WHERE JOB_ID NOT IN (2500,3500,7000)
							AND JOB_ID IN ('SA_REP','ST_CLERK');
							

						  
--[V] 66. 사원의 사원번호, 이름, 성, 상사의 사원번호, 상사의 이름, 상사의 성을 조회한다.
SELECT E.EMPLOYEE_ID
		 , E.FIRST_NAME
		 , E.LAST_NAME
		 , MA.EMPLOYEE_ID
		 , MA.FIRST_NAME
	FROM EMPLOYEES E
 INNER JOIN EMPLOYEES MA
 		ON E.EMPLOYEE_ID =MA.MANAGER_ID;

-- 67. 101번 사원의 모든 부하직원 들의 이름, 성, 상사사원번호, 상사사원명을 조회한다.
-- 68. 114번 직원의 모든 상사들의 이름, 성, 상사사원번호, 상사사원명을 조회한다.
-- 69. 114번 직원의 모든 상사들의 이름, 성, 상사사원번호, 상사사원명을 조회한다. 단, 역순으로 조회한다.
-- 70. 모든 사원들을 연봉 오름차순 정렬하여 조회한다.
        SELECT EMPLOYEE_ID
     				 , FIRST_NAME
     				 , LAST_NAME
     				 , EMAIL 
     				 , PHONE_NUMBER 
    				 , HIRE_DATE 
     				 , JOB_ID 
     				 , SALARY
     				 , COMMISSION_PCT 
     				 , MANAGER_ID 
     				 , DEPARTMENT_ID 
      	  FROM EMPLOYEES
         ORDER BY SALARY ASC;
-- 71. 모든 사원들을 이름 내림차순 정렬하여 조회한다.
        SELECT EMPLOYEE_ID
     				 , FIRST_NAME
     				 , LAST_NAME
     				 , EMAIL 
     				 , PHONE_NUMBER 
    				 , HIRE_DATE 
     				 , JOB_ID 
    		 		 , SALARY
    		 		 , COMMISSION_PCT 
   		  		 , MANAGER_ID 
    		 		 , DEPARTMENT_ID 
      	  FROM EMPLOYEES
         ORDER BY SALARY DESC;
-- 72. 모든 사원들의 이름, 성, 연봉, 부서명을 부서번호로 내림차순 정렬하여 조회한다.
 SELECT LAST_NAME
		  ,  DEPARTMENT_ID  
		  ,  FIRST_NAME
		  ,  SALARY
		  ,  DEPARTMENT_NAME 
	 FROM EMPLOYEES
	INNER JOIN DEPARTMENTS
	   ON EMPLOYEES.DEPARTMENT_ID = DEPARTMENTS.DEPARTMENT_ID
	ORDER BY DEPARTMENTS.DEPARTMENT_ID DESC;
-- 73. 부서명별 연봉의 합을 내림차순 정렬하여 조회한다.  
SELECT D.DEPARTMENT_NAME
		 , SUM(E.SALARY) AS HAP
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME
 ORDER BY HAP DESC;

-- 74. 직무명별 사원의 수를 오름차순 정렬하여 조회한다.
SELECT J.JOB_TITLE
		 , COUNT(E.EMPLOYEE_ID) AS CU
	FROM EMPLOYEES e
 INNER JOIN JOBS j
 		ON E.JOB_ID = J.JOB_ID
 GROUP BY J.JOB_TITLE
 ORDER BY CU ASC;
 		

-- 75. 모든 사원들의 모든 정보를 조회한다. 단, 인센티브를 받는 사원은 "인센티브여부" 컬럼에 "Y"를, 아닌 경우 "N"으로 조회한다.
-- 76. 모든 사원들의 이름을 10자리로 맞추어 조회한다.
-- [V]77. 2007년에 직무가 변경된 사원들/의 현재 직무명, 부서명, 사원번호, 이름, 성을 조회한다.
													SELECT J.JOB_TITLE
															 , D.DEPARTMENT_NAME 
															 , E.EMPLOYEE_ID
															 , E.FIRST_NAME
															 , E.LAST_NAME
														FROM EMPLOYEES e
													 INNER JOIN DEPARTMENTS d
 														  ON E.DEPARTMENT_ID  = D.DEPARTMENT_ID 
 													 INNER JOIN JOBS j
 														  ON E.JOB_ID = J.JOB_ID
													 INNER JOIN JOB_HISTORY jh
													 		ON E.EMPLOYEE_ID = jh.EMPLOYEE_ID 
													 WHERE JH.START_DATE BETWEEN TO_DATE('20070101','YYYYMMDD') 
													 												 AND TO_DATE('20080101','YYYYMMDD')-1;

-- 78. 직무별 최대연봉보다 더 많은 연봉을 받는 사원의 모든 정보를 조회한다.
		SELECT EMPLOYEE_ID
				 , FIRST_NAME
				 , LAST_NAME 
				 , EMAIL 
				 , PHONE_NUMBER 
				 , HIRE_DATE 
				 , JOB_ID 
				 , SALARY 
				 , COMMISSION_PCT 
				 , MANAGER_ID 
				 , DEPARTMENT_ID	
		  FROM EMPLOYEES e
		 WHERE SALARY > (SELECT MAX(SALARY)
						 				   FROM EMPLOYEES ep
						 				  WHERE e.JOB_ID = ep.JOB_ID);

-- 79. 사원들의 이름, 성, 입사연도만 조회한다.
		SELECT FIRST_NAME
				 , LAST_NAME
				 , TO_CHAR(HIRE_DATE,'YYYY')
			FROM EMPLOYEES;
-- 80. 사원들의 이름, 성, 입사연도, 입사월 만 조회한다.
		SELECT FIRST_NAME
				 , LAST_NAME
				 , TO_CHAR(HIRE_DATE,'YYYY-MM')
			FROM EMPLOYEES;
-- 81. 100번 사원의 모든 부하직원을 계층조회한다. 단, LEVEL이 4인 사원은 제외한다.
-- 82. 많은 연봉을 받는 10명을 조회한다.
-- 83. 가장 적은 연봉을 받는 사원/의 상사명, 부서명을 조회한다.
SELECT MIN(SALARY)
	FROM EMPLOYEES

SELECT E.FIRST_NAME
		 , D.DEPARTMENT_NAME
		 , E.EMPLOYEE_ID 
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 WHERE E.SALARY  = (SELECT MIN(SALARY)
											FROM EMPLOYEES);


-- 84. 많은 연봉을 받는 사원 중 11번 째 부터 20번째를 조회한다.
-- 85. 가장 적은 연봉을 받는 중 90번 째 부터 100번째를 조회한다.
-- 86. 'PU_CLERK' 직무인 2번째 부터 5번째 사원의 부서명, 직무명을 조회한다.
-- 87. 모든 사원의 정보를 직무 오름차순, 연봉 내림차순으로 조회한다.
				SELECT EMPLOYEE_ID
     				 , FIRST_NAME
     				 , LAST_NAME
     				 , EMAIL 
     				 , PHONE_NUMBER 
    				 , HIRE_DATE 
     				 , JOB_ID 
    		 		 , SALARY
    		 		 , COMMISSION_PCT 
   		  		 , MANAGER_ID 
    		 		 , DEPARTMENT_ID 
      	  FROM EMPLOYEES
      	 ORDER BY JOB_ID ASC 
    				 , SALARY DESC;
-- 88. 직무ID별 평균연봉을 평균연봉순으로 오름차순 정렬하여 조회한다.
			SELECT JOB_ID
					 , AVG(SALARY)
				FROM EMPLOYEES
			 GROUP BY JOB_ID
			 ORDER BY AVG(SALARY) ASC;
--위는 돌아는가지만 쓰레기 아래가 그나마괜찮 많은연산이 중첩인데 검증까지도무거운거임
			SELECT JOB_ID
					 , AVG(SALARY) AS AVG_SALARY
				FROM EMPLOYEES
			 GROUP BY JOB_ID
			 ORDER BY AVG_SALARY ASC;
-- 89. 부서번호별 평균연봉을 내림차순 정렬하여 조회한다.
				SELECT DEPARTMENT_ID
					   , AVG(SALARY) AS AVG_SALARY
					FROM EMPLOYEES
			 	 GROUP BY DEPARTMENT_ID
			 	 ORDER BY AVG_SALARY DESC;
-- 90. 이름의 첫 번째 글자별 평균연봉을 조회한다.
-- 91. 입사연도별 최소연봉을 조회한다.
-- 92. 월별 최대연봉 중 2번째 부터 4번째 데이터만 조회한다.
-- 93. 직무명별 최소연봉을 조회한다.
SELECT j.JOB_TITLE
		 , MIN(E.SALARY) 
	FROM EMPLOYEES e
 INNER JOIN JOBS j
 		ON E.JOB_ID = J.JOB_ID
 GROUP BY J.JOB_TITLE;
 	

-- 94. 부서명별 최대연봉을 조회한다.

SELECT D.DEPARTMENT_NAME
		 , MAX(E.SALARY)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME;
 	
-- 95. 직무명, 부서명 별 사원 수, 평균연봉을 조회한다.
SELECT j.JOB_TITLE
		 , D.DEPARTMENT_NAME
		 , COUNT(E.EMPLOYEE_ID)
		 , AVG(E.SALARY)
	FROM EMPLOYEES e
 INNER JOIN JOBS j
 		ON E.JOB_ID = J.JOB_ID
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY J.JOB_TITLE,D.DEPARTMENT_NAME;
 
-- 96. 도시별 사원 수를 조회한다.
SELECT L.CITY
		 , COUNT(E.EMPLOYEE_ID)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 GROUP BY L.CITY;
 	

-- 97. 국가별 사원 수, 최대연봉, 최소연봉을 조회한다.
SELECT C.COUNTRY_NAME
		 , COUNT(E.EMPLOYEE_ID)
		 , MAX(E.SALARY)
		 , MIN(E.SALARY)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 INNER JOIN COUNTRIES c 
 		ON L.COUNTRY_ID = C.COUNTRY_ID
 GROUP BY C.COUNTRY_NAME;
 
	

-- 98. 대륙별 사원 수를 대륙명으로 오름차순 정렬하여 조회한다.
SELECT R.REGION_NAME
		 , COUNT(E.EMPLOYEE_ID) AS RCOUNT
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 INNER JOIN COUNTRIES c 
 		ON L.COUNTRY_ID = C.COUNTRY_ID
 INNER JOIN REGIONS r
 		ON C.REGION_ID = R.REGION_ID
 GROUP BY R.REGION_NAME
 ORDER BY RCOUNT ASC;

-- 99. 이름이나 성에 'A' 혹은 'a' 가 포함된 사원의 모든 정보를 조회한다.
			SELECT EMPLOYEE_ID
           , FIRST_NAME
           , LAST_NAME
           , EMAIL 
           , PHONE_NUMBER 
           , HIRE_DATE 
           , JOB_ID 
           , SALARY
           , COMMISSION_PCT 
           , MANAGER_ID 
           , DEPARTMENT_ID 
        FROM EMPLOYEES
       WHERE FIRST_NAME LIKE '%A%' 
       		OR FIRST_NAME LIKE '%a%'
          OR LAST_NAME LIKE '%A%' 
          OR LAST_NAME LIKE '%a%';

-- 100. 국가별로 연봉이 5000 이상인 사원의 수를 조회한다.
SELECT C.COUNTRY_NAME
		 , COUNT(E.EMPLOYEE_ID)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 INNER JOIN COUNTRIES c 
 		ON L.COUNTRY_ID = C.COUNTRY_ID
 WHERE E.SALARY >= 5000
 GROUP BY C.COUNTRY_NAME;
 

-- [V]101. 인센티브를 안받는 사원이 근무하는 도시를 조회한다.
SELECT DISTINCT L.CITY
	FROM EMPLOYEES e 
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 WHERE E.COMMISSION_PCT IS NULL;
	
-- 102. 인센티브를 포함한 연봉이 10000 이상인 사원의 모든 정보를 조회한다.
-- 103. 가장 많은 부서가 있는 도시를 조회한다.
-- 104. 가장 많은 사원이 있는 부서의 국가명을 조회한다.
-- [V]105. 우편번호가 5자리인 도시에서 근무하는 사원명, 부서명, 도시명, 우편번호를 조회한다.
SELECT E.FIRST_NAME
		 , D.DEPARTMENT_NAME
		 , L.CITY
		 , L.POSTAL_CODE
	FROM EMPLOYEES e 
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 WHERE L.POSTAL_CODE LIKE '_____';
-- [V]106. 우편번호에 공백이 없는 도시에서 근무하는 사원의 이름, 부서명, 우편번호를 조회한다.


--SELECT E.FIRST_NAME
--		 , D.DEPARTMENT_NAME
--		 , L.CITY
--		 , L.POSTAL_CODE
--	FROM EMPLOYEES e 
-- INNER JOIN DEPARTMENTS d
-- 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
-- INNER JOIN LOCATIONS l
-- 		ON D.LOCATION_ID = L.LOCATION_ID
-- WHERE INSTR(L.POSTAL_CODE,' ')>0;?????????????????

SELECT E.FIRST_NAME
		 , D.DEPARTMENT_NAME
		 , L.CITY
		 , L.POSTAL_CODE
	FROM EMPLOYEES e 
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 WHERE L.POSTAL_CODE NOT LIKE '% %';
-- [V]107. "주"가 없는 도시에서 근무하는 사원의 이름, 도시를 조회한다.
SELECT E.FIRST_NAME
		 , D.DEPARTMENT_NAME
		 , L.CITY
		 , L.POSTAL_CODE
	FROM EMPLOYEES e 
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 WHERE L.STATE_PROVINCE IS NULL;
-- 108. 국가명이 6자리인 국가의 모든 정보를 조회한다.
	SELECT COUNTRY_ID
			 , COUNTRY_NAME
			 , REGION_ID
		FROM COUNTRIES
	 WHERE COUNTRY_NAME LIKE '______';
-- 109. 사원의 이름과 성을 이용해 EMAIL과 같은 값으로 만들어 조회한다.
-- 110. 모든 사원들의 이름을 10자리로 변환해 조회한다. 예> 이름 => "        이름"
-- 111. 모든 사원들의 성을 10자리로 변환해 조회한다. 예> 성 => "성         "
-- 112. 109번 사원의 입사일 부터 1년 내에 입사한 사원의 모든 정보를 조회한다.
		SELECT EMPLOYEE_ID
				 , FIRST_NAME
				 , LAST_NAME
				 , EMAIL
				 , PHONE_NUMBER
				 , HIRE_DATE
				 , JOB_ID
				 , SALARY
				 , COMMISSION_PCT
				 , MANAGER_ID
				 , DEPARTMENT_ID
		  FROM EMPLOYEES
		 WHERE HIRE_DATE BETWEEN (SELECT HIRE_DATE
		 														FROM EMPLOYEES
		 						   							WHERE EMPLOYEE_ID = 109) AND (SELECT ADD_MONTHS(HIRE_DATE, 12)
																										 						FROM EMPLOYEES
																										 					 WHERE EMPLOYEE_ID = 109); 

-- 113. 가장 먼저 입사한 사원의 입사일로부터 2년 내에 입사한사원의 모든 정보를 조회한다.
				SELECT EMPLOYEE_ID
						 , FIRST_NAME
						 , LAST_NAME
						 , EMAIL
						 , PHONE_NUMBER
						 , HIRE_DATE
						 , JOB_ID
						 , SALARY
						 , COMMISSION_PCT
						 , MANAGER_ID
						 , DEPARTMENT_ID
				  FROM EMPLOYEES
				 WHERE HIRE_DATE BETWEEN (SELECT MIN(HIRE_DATE) FROM EMPLOYEES)
				 				 						 AND (SELECT ADD_MONTHS(MIN(HIRE_DATE),12*2) FROM EMPLOYEES);
-- 114. 가장 늦게 입사한 사원의 입사일 보다 1년 앞서 입사한 사원의 모든 정보를 조회한다.
				SELECT EMPLOYEE_ID
						 , FIRST_NAME
						 , LAST_NAME
						 , EMAIL
						 , PHONE_NUMBER
						 , HIRE_DATE
						 , JOB_ID
						 , SALARY
						 , COMMISSION_PCT
						 , MANAGER_ID
						 , DEPARTMENT_ID
				  FROM EMPLOYEES
				 WHERE HIRE_DATE BETWEEN (SELECT ADD_MONTHS(MAX(HIRE_DATE),-12) FROM EMPLOYEES) 
				 				 						 AND (SELECT MAX(HIRE_DATE) FROM EMPLOYEES);

-- [V]115. 도시명에 띄어쓰기 " " 가 포함된 도시에서 근무중인 사원들의 부서명, 도시명, 사원명을 조회한다.
SELECT D.DEPARTMENT_NAME
		 , L.CITY
		 , E.FIRST_NAME
	FROM EMPLOYEES e 
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 WHERE L.CITY LIKE '% %';

-- 116. MOD 함수를 통해 사원번호가 홀수면 남자, 짝수면 여자 로 구분해 조회한다. MOD(값, 나눌값)
	
	
-- 117. '20230222' 문자 데이터를 날짜로 변환해 조회한다.(DUAL)
	SELECT TO_CHAR(TO_DATE('20230222','YYYYMMDD') , 'YYYY-DD-MM')
	FROM DUAL;
-- 118. '20230222' 문자 데이터를 'YYYY-MM' 으로 변환해 조회한다.(DUAL)
	SELECT TO_CHAR(TO_DATE('20230222','YYYYMMDD') , 'YYYY-MM')
	FROM DUAL;
-- 119. '20230222130140' 문자 데이터를 'YYYY-MM-DD HH24:MI:SS' 으로 변환해 조회한다. (DUAL)
	SELECT TO_CHAR(TO_DATE('20230222130140','YYYYMMDDHH24MISS') , 'YYYY-MM-DD HH24:MI:SS')
	FROM DUAL;
-- 120. '20230222' 날짜의 열흘 후의 날짜를 'YYYY-MM-DD' 으로 변환해 조회한다. (DUAL)
	SELECT TO_CHAR(TO_DATE('20230222','YYYYMMDD') + 10 , 'YYYY-MM-DD')
	FROM DUAL;
-- 121. 사원 이름의 글자수 별 사원의 수를 조회한다.
-- 122. 사원 성의 글자수 별 사원의 수를 조회한다.
-- 123. 사원의 연봉이 5000 이하이면 "사원", 7000 이하이면 "대리", 9000 이하이면 "과장", 그 외에는 임원 으로 조회한다.
-- 124. 부서별 사원의 수를 조인을 이용해 다음과 같이 조회한다."부서명 (사원의 수)"
-- 125. 부서별 사원의 수를 스칼라쿼리를 이용해 다음과 같이 조회한다. "부서명 (사원의 수)"
-- 126. 사원의 정보를 다음과 같이 조회한다. "사원번호 번 사원의 이름은 성이름 입니다."
-- 127. 사원의 정보를 스칼라쿼리를 이용해 다음과 같이 조회한다. "사원번호 번 사원의 상사명은 상사명 입니다."
-- 128. 사원의 정보를 조인을 이용해 다음고 같이 조회한다. "사원명 (직무명)"
-- 129. 사원의 정보를 스칼라쿼리를 이용해 다음과 같이 조회한다. "사원명 (직무명)"
-- 130. 부서별 연봉 차이(최고연봉 - 최저연봉)가 가장 큰 부서명을 조회한다.
-- 131. 부서별 연봉 차이(최고연봉 - 최저연봉)가 가장 큰 부서에서 근무하는 사원들의 직무명을 중복없이 조회한다.
-- 132. 부서장이 없는 부서명 중 첫 글자가 'C' 로 시작하는 부서명을 조회한다.
					 	 SELECT DEPARTMENT_ID
						 			, DEPARTMENT_NAME
						 			, MANAGER_ID
						 			, LOCATION_ID
							 FROM DEPARTMENTS
							WHERE DEPARTMENT_NAME LIKE 'C%'
						    AND MANAGER_ID IS NULL;

-- 133. 부서장이 있는 /부서명 중 첫 글자가 'S'/ 로 시작하는 부서에서/ 근무중인 사원의 이름과 직무명, 부서명을 조회한다.


SELECT E.FIRST_NAME 
		 , D.DEPARTMENT_NAME
		 , J.JOB_TITLE
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN JOBS j 
 		ON E.JOB_ID = J.JOB_ID
 WHERE D.MANAGER_ID IS NOT NULL
 	 AND D.DEPARTMENT_NAME LIKE 'S%';
	

-- 134. 지역변호가 1000 ~ 1999 사이인 지역내 부서의 모든 정보를 조회한다.
	SELECT DEPARTMENT_ID
			 , DEPARTMENT_NAME
			 , MANAGER_ID
			 , LOCATION_ID
	  FROM DEPARTMENTS
	 WHERE LOCATION_ID BETWEEN 1000 AND 1999;
	
--[V] 135. 90, 60, 100번 부서에서 근무중인 사원의 이름, 성, 부서명을 조회한다.
SELECT E.FIRST_NAME
		 , E.LAST_NAME
		 , D.DEPARTMENT_NAME
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 WHERE D.DEPARTMENT_ID LIKE '9%'
 		OR D.DEPARTMENT_ID LIKE '6%'
 		OR D.DEPARTMENT_ID LIKE '10%';

-- 136. 부서명이 5글자 미만인 부서에서 근무중인 사원의 이름, 부서명을 조회한다.
-- 137. 국가 아이디가 'C'로 시작하는 국가의 지역을 모두 조회한다.
	SELECT LOCATION_ID
			 , STREET_ADDRESS
			 , POSTAL_CODE
			 , CITY
			 , STATE_PROVINCE
			 , COUNTRY_ID
		FROM LOCATIONS
	 WHERE COUNTRY_ID LIKE 'C%';

--국가명이 'a'로 끝나는 국가의 모든 정보를 조회한다.
	SELECT COUNTRY_ID
			 , COUNTRY_NAME
			 , REGION_ID
		FROM COUNTRIES
	 WHERE COUNTRY_NAME LIKE '%a';

--국가명이 'a'로 끝나지 않는 국가의 모든 정보를 조회
	SELECT COUNTRY_ID
			 , COUNTRY_NAME
			 , REGION_ID
		FROM COUNTRIES
	 WHERE COUNTRY_NAME NOT LIKE '%a';

-- 138. 국가 아이디의 첫 글자와 국가명의 첫 글자가 다른 모든 국가를 조회한다.
-- 139. 사원 모든 정보 중 이메일만 모두 소문자로 변경하여 조회한다.
-- 140. 사원의 연봉을 TRUNC(소수점 버림) 함수를 사용해 100 단위는 버린채 다음과 같이 조회한다. 예> 3700 -> 3000, 12700 -> 12000
-- 141. 100단위를 버린 사원의 연봉 별 사원의 수를 조회한다.
-- 142. 현재 시간으로부터 20년 전 보다 일찍 입사한 사원의 모든 정보를 조회한다.
 SELECT EMPLOYEE_ID
      , IRST_NAME
      , AST_NAME
      , MAIL 
      , HONE_NUMBER 
      , IRE_DATE 
      , OB_ID 
      , SALARY
      , COMMISSION_PCT 
   		, ANAGER_ID 
      , DEPARTMENT_ID 
	 FROM EMPLOYEES
	WHERE HIRE_DATE < ADD_MONTHS(SYSDATE, -20*12);

-- 143. 부서번호별 현재 시간으로부터 15년 전 보다 일찍 입사한 사원의 수를 조회한다.
SELECT D.DEPARTMENT_ID
		 , COUNT(E.EMPLOYEE_ID)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 WHERE E.HIRE_DATE < ADD_MONTHS(SYSDATE, -15*12)
 GROUP BY D.DEPARTMENT_ID;
-- 144. 부서명, 직무명 별 평균 연봉을 조회한다.
SELECT D.DEPARTMENT_NAME
		 , j.JOB_TITLE
		 , AVG(E.SALARY) 
  FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 	  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN JOBS j
 		ON E.JOB_ID = J.JOB_ID
 GROUP BY D.DEPARTMENT_NAME,J.JOB_TITLE;
-- 145. 도시명, 직무명 별 사원의 수를 조회한다.
SELECT L.CITY
		 , j.JOB_TITLE
		 , COUNT(E.EMPLOYEE_ID)
  FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 	  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN JOBS j
 		ON E.JOB_ID = J.JOB_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 GROUP BY L.CITY, J.JOB_TITLE;
-- 146. 부서명, 직무명 별 평균 연봉 중 가장 작은 평균연봉을 받는 부서명, 직무명을 조회한다.
-- 147. 102번 직원의 모든 부하직원의 수를 조회한다.
-- 148. 113번 직원의 모든 부하직원의 수를 조회한다.
-- 149. 부하직원이 없는 사원의 모든 정보를 조회한다.
SELECT EMPLOYEE_ID
      , FIRST_NAME
      , LAST_NAME
      , EMAIL 
      , PHONE_NUMBER 
      , HIRE_DATE 
      , JOB_ID 
      , SALARY
      , COMMISSION_PCT 
   		, MANAGER_ID 
      , DEPARTMENT_ID 
	FROM EMPLOYEES 
 WHERE EMPLOYEE_ID NOT IN (SELECT DISTINCT MANAGER_ID
														FROM EMPLOYEES
														WHERE MANAGER_ID IS NOT NULL);

-- 150. 사원번호가 100번인 사원의 사원번호, 이름과 사원번호로 내림차순 정렬된 사원의 사원번호, 이름 조회한다.
/*조회 예
--------------------
100    Steven
206    William
205    Shelley
204    Hermann
203    Susan
202    Pat
201    Michael
200    Jennifer
199    Douglas
198    Donald
197    Kevin
196    Alana
...
*/

--	1. 모든 사원의 모든 정보를 조회한다.107
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
						 FROM EMPLOYEES;
--2. 부서가 없는 사원의 모든 정보를 조회한다.1
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
						 FROM EMPLOYEES
						WHERE DEPARTMENT_ID IS NULL;

--3. 직무가 없는 사원의 모든 정보를 조회한다.0
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
						 FROM EMPLOYEES
						WHERE JOB_ID IS NULL;
--4. 부서와 직무가 모두 있는 사원의 모든 정보를 조회한다.106
					 SELECT EMPLOYEE_ID
								, FIRST_NAME
								, LAST_NAME
								, EMAIL
								, PHONE_NUMBER
								, HIRE_DATE    
								, JOB_ID
								, SALARY
								, COMMISSION_PCT
								, MANAGER_ID
								, DEPARTMENT_ID
						 FROM EMPLOYEES
						WHERE JOB_ID IS NOT NULL
						  AND DEPARTMENT_ID IS NOT NULL;
--5. 부서장이 없는 모든 부서의 모든 정보를 조회한다.16
					 SELECT DEPARTMENT_ID
					 			, DEPARTMENT_NAME
					 			, MANAGER_ID
					 			, LOCATION_ID
						 FROM DEPARTMENTS
						WHERE MANAGER_ID IS NULL;
--6. 부서장이 있는 모든 부서의 모든 정보를 조회한다.11
					 SELECT DEPARTMENT_ID
					 			, DEPARTMENT_NAME
					 			, MANAGER_ID
					 			, LOCATION_ID
						 FROM DEPARTMENTS
						WHERE MANAGER_ID IS NOT NULL;
--7. 사원의 이름만 조회한다.107
					 SELECT FIRST_NAME
						 FROM EMPLOYEES;
--8. 모든 지역의 모든 정보를 조회한다.23
					 SELECT LOCATION_ID
					 			, STREET_ADDRESS
					 			, POSTAL_CODE
					 			, CITY
					 			, STATE_PROVINCE
					 			, COUNTRY_ID
						 FROM LOCATIONS;
--9. 지역이 없는 모든 부서의 정보를 조회한다.0
					 SELECT DEPARTMENT_ID
					 			, DEPARTMENT_NAME
					 			, MANAGER_ID
					 			, LOCATION_ID
						 FROM DEPARTMENTS
						WHERE LOCATION_ID IS NULL;
	


--최고월급을 받는 사원들의 사원 번호와 월급을 조회한다.
--1. 모르는걸? ==> 최고월급 ==>2400
	SELECT MAX(SALARY)
		FROM EMPLOYEES
	
	SELECT EMPLOYEE_ID
			 , SALARY
		FROM EMPLOYEES
	 WHERE SALARY=(SELECT MAX(SALARY)
	 								 FROM EMPLOYEES);
		

--평균 월급보다 적게 받은 사람들의 사원번호와 월급을 조회한다.
	
	SELECT AVG(SALARY)
		FROM EMPLOYEES
		
		SELECT EMPLOYEE_ID
				 , SALARY
		  FROM EMPLOYEES
		  WHERE SALARY<(SELECT AVG(SALARY)
		  								FROM EMPLOYEES);
--수행하는 직무의 이름이 'Finance Manager'인 사원의 사원번호와 직무아이디를 조회한다.
		SELECT EMPLOYEE_ID
				 , JOB_ID
			FROM EMPLOYEES
		 WHERE JOB_ID = (SELECT JOB_ID
		 										FROM JOBS S
		 									 WHERE S.JOB_TITLE  = 'Finance Manager');
		
--Seattle에서 근무하는 사원의 이름,성,부서번호를 조회한다

--		1 . SEATTLE의 지역번호가 뭔지모른다
--		2. SEARTTLE에 있는 부서들의 번호가 무었인지 모른다
--		SEATTLE에 있는 부서들의 번호가 무었인지 안다면 사원의 이름과 성 부서번호를 조회할수있다
		
--		SELECT LOCATION_ID
--		  FROM LOCATIONS
--		 WHERE CITY = 'Seattle';
		
		
--		SELECT DEPARTMENT_ID
--			FROM DEPARTMENTS
--		 WHERE LOCATION_ID = (SELECT LOCATION_ID
--										 				FROM LOCATIONS
--										 			 WHERE CITY = 'Seattle');
		
		SELECT FIRST_NAME
				 , LAST_NAME
				 , DEPARTMENT_ID
			FROM EMPLOYEES
		 WHERE DEPARTMENT_ID IN(SELECT DEPARTMENT_ID
															FROM DEPARTMENTS
														 WHERE LOCATION_ID = (SELECT LOCATION_ID
																							 			FROM LOCATIONS
																							 		 WHERE CITY = 'Seattle'));

---- 추가 문제

-- 1. (12건) 부서아이디별 사원의 평균연봉을 조회한다.

	SELECT AVG(SALARY)
		FROM EMPLOYEES
GROUP BY DEPARTMENT_ID;
	
-- 2. (19건) 직무아이디별 사원의 최고연봉을 조회한다.
	SELECT MAX(SALARY)
		FROM EMPLOYEES
GROUP BY JOB_ID;

-- 3. (72건) 인센티브를 안받는 사원의 모든 정보를 조회한다.
SELECT EMPLOYEE_ID
		 , FIRST_NAME
		 , LAST_NAME
		 , EMAIL
		 , PHONE_NUMBER
		 , HIRE_DATE    
		 , JOB_ID
		 , SALARY
		 , COMMISSION_PCT
		 , MANAGER_ID
		 , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL;
-- 4. (2건) 인센티브를 받는 사원의 부서아이디를 중복없이 조회한다.
SELECT DISTINCT DEPARTMENT_ID 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL;
-- 5. (2건) 인센티브를 받는 사원의 직무아이디를 중복없이 조회한다.
SELECT DISTINCT JOB_ID 
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL;
-- 6. (7건) 사원이 있는 부서의 지역아이디를 조회한다.

SELECT DEPARTMENT_ID
	FROM EMPLOYEES
	WHERE DEPARTMENT_ID IS NOT NULL;

SELECT DISTINCT LOCATION_ID
	FROM DEPARTMENTS
 WHERE DEPARTMENT_ID IN (SELECT DEPARTMENT_ID
													 FROM EMPLOYEES
													WHERE DEPARTMENT_ID IS NOT NULL);

-- 7. (21건) Seattle에 존재하는 부서번호를 조회한다.
SELECT DEPARTMENT_ID
	FROM DEPARTMENTS
 WHERE LOCATION_ID = (SELECT LOCATION_ID
 											  FROM LOCATIONS
 											 WHERE CITY = 'Seattle');


-- 8. (16건) 사원이 한명도 없는 도시를 조회한다.
SELECT LOCATION_ID
		 , STREET_ADDRESS
		 , POSTAL_CODE
		 , CITY
		 , STATE_PROVINCE
		 , COUNTRY_ID
  FROM LOCATIONS
 WHERE LOCATION_ID NOT IN (SELECT DISTINCT LOCATION_ID
 						 	 							 FROM DEPARTMENTS
 														WHERE DEPARTMENT_ID IN (SELECT DISTINCT DEPARTMENT_ID
 												  	  												FROM EMPLOYEES));
-- 9. (7건) 사원이 한명이라도 있는 도시를 조회한다.
SELECT LOCATION_ID
		 , STREET_ADDRESS
		 , POSTAL_CODE
		 , CITY
		 , STATE_PROVINCE
		 , COUNTRY_ID
  FROM LOCATIONS
 WHERE LOCATION_ID IN (SELECT DISTINCT LOCATION_ID
 						 	 					 FROM DEPARTMENTS
 												WHERE DEPARTMENT_ID IN (SELECT DISTINCT DEPARTMENT_ID
 												  	  										FROM EMPLOYEES));
-- 10. (107건) 모든 사원의 정보를 연봉으로 오름차순 정렬하여 조회한다.
	SELECT EMPLOYEE_ID
			 , FIRST_NAME
			 , LAST_NAME
			 , EMAIL
			 , PHONE_NUMBER
			 , HIRE_DATE    
			 , JOB_ID
			 , SALARY
			 , COMMISSION_PCT
			 , MANAGER_ID
			 , DEPARTMENT_ID
	  FROM EMPLOYEES
ORDER BY SALARY ASC;

-- 11. (107건) 모든 사원의 사원번호, 이름, 성, 연봉, 인센티브를 포함한 연봉 정보를 조회한다.
	SELECT EMPLOYEE_ID
			 , FIRST_NAME
			 , LAST_NAME
			 , SALARY
--			 , COMMISSION_PCT
			 , SALARY + (SALARY * NVL(COMMISSION_PCT, 0)) AS TOTAL_SALARY
	  FROM EMPLOYEES;

-- 12. (6건) 2003년에 입사한 사원은 몇 명인지 조회한다.
SELECT COUNT(HIRE_DATE)
	FROM EMPLOYEES
 WHERE HIRE_DATE BETWEEN TO_DATE('2003-01-01','YYYY-MM-DD') 
 										 AND TO_DATE('2004-01-01','YYYY-MM-DD');
-- 13. (1건) 113번 사원의 상사의 모든 정보를 조회한다.
SELECT MANAGER_ID
	FROM EMPLOYEES
 WHERE EMPLOYEE_ID  = '113';

	SELECT EMPLOYEE_ID
			 , FIRST_NAME
			 , LAST_NAME
			 , EMAIL
			 , PHONE_NUMBER
			 , HIRE_DATE    
			 , JOB_ID
			 , SALARY
			 , COMMISSION_PCT
			 , MANAGER_ID
			 , DEPARTMENT_ID
	  FROM EMPLOYEES
	 WHERE EMPLOYEE_ID = (SELECT MANAGER_ID
													FROM EMPLOYEES
												 WHERE EMPLOYEE_ID  = '113');

-- 14. (11건) 모든 부서의 부서장의 모든 사원 정보를 조회한다.
		SELECT MANAGER_ID
			FROM DEPARTMENTS
		 WHERE MANAGER_ID IS NOT NULL;
		
	
	SELECT EMPLOYEE_ID
			 , FIRST_NAME
			 , LAST_NAME
			 , EMAIL
			 , PHONE_NUMBER
			 , HIRE_DATE    
			 , JOB_ID
			 , SALARY
			 , COMMISSION_PCT
			 , MANAGER_ID
			 , DEPARTMENT_ID
	  FROM EMPLOYEES
	 WHERE EMPLOYEE_ID IN (SELECT MANAGER_ID
													 FROM DEPARTMENTS
													WHERE MANAGER_ID IS NOT NULL);
-- 15. (23건) 사원의 이름이 7자리인 사원의 모든 정보를 조회한다.
	SELECT EMPLOYEE_ID
			 , FIRST_NAME
			 , LAST_NAME
			 , EMAIL
			 , PHONE_NUMBER
			 , HIRE_DATE    
			 , JOB_ID
			 , SALARY
			 , COMMISSION_PCT
			 , MANAGER_ID
			 , DEPARTMENT_ID
	  FROM EMPLOYEES
	 WHERE FIRST_NAME LIKE '_______';
-- 16. (25건) 사원의 이메일이 6자리인 사원의 모든 정보를 조회한다.
	SELECT EMPLOYEE_ID
			 , FIRST_NAME
			 , LAST_NAME
			 , EMAIL
			 , PHONE_NUMBER
			 , HIRE_DATE    
			 , JOB_ID
			 , SALARY
			 , COMMISSION_PCT
			 , MANAGER_ID
			 , DEPARTMENT_ID
	  FROM EMPLOYEES
	 WHERE EMAIL LIKE '______';
	
	
	-- 1. 모든 부서들의 정보와 도시 정보를 조회한다.(27)
	
SELECT D.DEPARTMENT_ID
		 , D.DEPARTMENT_NAME
		 , D.LOCATION_ID
		 , D.MANAGER_ID
		 , L.CITY
		 , L.COUNTRY_ID
		 , L.LOCATION_ID
		 , L.POSTAL_CODE
		 , L.STATE_PROVINCE
		 , L.STREET_ADDRESS
	FROM DEPARTMENTS d
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID;
 

-- 2. 모든 사원들의 정보와 부서명을 조회한다.(106)

SELECT e.EMPLOYEE_ID
		 , e.FIRST_NAME
		 , e.LAST_NAME
		 , e.EMAIL
		 , e.PHONE_NUMBER
		 , e.HIRE_DATE    
		 , e.JOB_ID
		 , e.SALARY
		 , e.COMMISSION_PCT
		 , e.MANAGER_ID
		 , e.DEPARTMENT_ID
		 , d.DEPARTMENT_NAME 
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID ;
 		
-- 3. 111번 사원의 모든 정보와 부서명을 조회한다.
SELECT e.EMPLOYEE_ID
		 , e.FIRST_NAME
		 , e.LAST_NAME
		 , e.EMAIL
		 , e.PHONE_NUMBER
		 , e.HIRE_DATE    
		 , e.JOB_ID
		 , e.SALARY
		 , e.COMMISSION_PCT
		 , e.MANAGER_ID
		 , e.DEPARTMENT_ID
		 , d.DEPARTMENT_NAME 
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 WHERE E.EMPLOYEE_ID =111;
 		
-- 4. 115번의 사원의 모든 정보와 부서명, 직무명을 조회한다.(1)
SELECT e.EMPLOYEE_ID
		 , e.FIRST_NAME
		 , e.LAST_NAME
		 , e.EMAIL
		 , e.PHONE_NUMBER
		 , e.HIRE_DATE    
		 , e.JOB_ID
		 , e.SALARY
		 , e.COMMISSION_PCT
		 , e.MANAGER_ID
		 , e.DEPARTMENT_ID
		 , d.DEPARTMENT_NAME
		 , J.JOB_TITLE 
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN JOBS j
 		ON E.JOB_ID =J.JOB_ID
 WHERE E.EMPLOYEE_ID =115;
-- 5. 100번 사원의 모든 정보와 부서명, 직무명, 도시명을 조회한다.(1)
SELECT e.EMPLOYEE_ID
		 , e.FIRST_NAME
		 , e.LAST_NAME
		 , e.EMAIL
		 , e.PHONE_NUMBER
		 , e.HIRE_DATE    
		 , e.JOB_ID
		 , e.SALARY
		 , e.COMMISSION_PCT
		 , e.MANAGER_ID
		 , e.DEPARTMENT_ID
		 , d.DEPARTMENT_NAME
		 , J.JOB_TITLE
		 , L.CITY
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN JOBS j
 		ON E.JOB_ID =J.JOB_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID   
 WHERE E.EMPLOYEE_ID = 100;
-- 6. 부서명별 사원의 수를 조회한다.(11)
SELECT D.DEPARTMENT_NAME
		 , COUNT(E.EMPLOYEE_ID)
	FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
 		ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME;
-- 7. 직무명별 사원의 평균월급을 조회한다.(19)
SELECT J.JOB_TITLE
		 , AVG(E.SALARY) 
	FROM EMPLOYEES e
 INNER JOIN JOBS j
 		ON E.JOB_ID = J.JOB_ID
 GROUP BY J.JOB_TITLE
 		
-- 8. 부서명, 직무명별 사원의 수와 평균월급을 조회한다.(19)
SELECT D.DEPARTMENT_NAME
		 , J.JOB_TITLE
		 , COUNT(E.EMPLOYEE_ID)
		 , AVG(E.SALARY)
  FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
	  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN JOBS j
 		ON E.JOB_ID = J.JOB_ID
 GROUP BY D.DEPARTMENT_NAME,J.JOB_TITLE;
 		
-- 9. 부서명별 평균월급을 부서명으로 내림차순 정렬하여 조회한다.(11)
SELECT D.DEPARTMENT_NAME
		 , AVG(e.SALARY) AS AVSAL
  FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
	  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME
 ORDER BY AVSAL DESC;
-- 10. 부서명별 최고월급을 최고월급으로 오름차순 정렬하여 조회한다.(11)
SELECT D.DEPARTMENT_NAME
		 , MAX(e.SALARY) AS MAXSAL
  FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
	  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 GROUP BY D.DEPARTMENT_NAME
 ORDER BY MAXSAL ASC;
-- 11. 도시명 별 사원의 수를 도시명으로 오름차순 정렬하여 조회한다.(7)
SELECT L.CITY
		 , COUNT(E.EMPLOYEE_ID) AS EPC
  FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
	  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 GROUP BY L.CITY
 ORDER BY EPC ASC;
-- 12. 도시별 부서의 수를 조회한다.(7)
SELECT L.CITY
		 , COUNT(d.DEPARTMENT_ID)
  FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
	  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 GROUP BY L.CITY;
-- 13. 도시별 사원의 평균월급을 조회한다.(7)
	SELECT L.CITY
		 , AVG(E.SALARY)
  FROM EMPLOYEES e
 INNER JOIN DEPARTMENTS d
	  ON E.DEPARTMENT_ID = D.DEPARTMENT_ID
 INNER JOIN LOCATIONS l
 		ON D.LOCATION_ID = L.LOCATION_ID
 GROUP BY L.CITY;
 
 