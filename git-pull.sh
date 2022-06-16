
git_pull(){
    echo $1
    if [ $1 -eq 15 ];then
        return
    fi
    git pull
    if [ $? -ne 0 ];then 
        git_pull
    fi
}

git_pull 0