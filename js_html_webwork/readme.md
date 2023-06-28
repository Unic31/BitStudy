# 깃명령어

로컬저장소:  파일이나 디렉토리를 저장하는 장소. 로컬 디렉토리로 저장된 티렉토리 안에 .git이 생성되는데 
            그 안에 각종 소스코드나 브랜치등 정보가 저장됨
            로컬 저장소에 소스코드를 저장하는 명령 : commit

원격저장소:     서버나 네트워크에 있는 저장소를 의미
(repositorys)  일방적으로 로컬 저장소에 저장 후 원격 저장소에 저장하는 방식
               명령어는 : push

git init :  로컬 디렉토리로 지정. 하면 폴더 안에 .git가 생성됨

git remote add origin https://github.com/Unic31/bit701VisualStudioCode.git
경로지정(기존의 다른 깃주소에 이미 연결되어 있을 경우 오류 발생)

git remote set-url origin https://github.com/Unic31/bit701VisualStudioCode.git
오류시 경로재지정

git clone https://github.com/Unic31/bit701VisualStudioCode.git
경로의 코드를 컴퓨터에 복사해서 가져옴

git commit -m "메세지"
commit(로컬에 저장)

git push origin 브랜치명
push(로컬의 변경 내용을 온라인으로 저장)

git pull origin 브랜치명
pull(온라인에서 변경 내용을 로컬에 저장)

git branch 새브랜치명
새 브랜치 생성

git branch
브랜치 조회

git chekout 브랜치명
브랜치간 이동

git branch 브랜치명 -d 또는 git branch -d 브랜치명
브랜치 제거

git log
깃 로그

*A의 브랜치에 B의 브랜치의 소스코드를 병합하려면*
git checkout A
git merge B

git에 그날 수업한 자료 올리려면(study 폴더에서 gitbash 를 연다)
1. git add .
2. git commit -m "메세지"
3. git psuh origin master

