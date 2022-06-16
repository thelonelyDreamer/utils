

maven_install(){
    cd $1
    mvn install
    cd ..
}

dir_arr=("java8-utils" "utils-java8-boot-autoconfigure" "utils-java8-boot-starter")

for loop in ${dir_arr[@]}
do
    echo $loop;
    maven_install $loop
done