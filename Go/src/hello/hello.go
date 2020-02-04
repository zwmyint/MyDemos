package main
import "fmt"

func main() {
	//变量的默认值
	// int, float 0
	// string ""
	// array nil
	fmt.Println("Hello, Go Go!")
	var num = 100
	fmt.Printf("%d, %p\n", num, &num)
	var name = "python"
	fmt.Printf("%s, %T, %p\n", name, name, &name)

	//Const
	const a = 1
	// a = 2 报错
	//枚举
	const (
		SPRING = 0
		SUMMER = 1
		AUTUMN = 2
		WINTER = 3
	)

	fmt.Printf("%T, %d", SPRING, SPRING)

	

}