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


	//itoa

	const(
		e = iota
		r = iota
		t = iota
	)
	fmt.Printf("\n-------\n")
  fmt.Printf("%d, %d, %d\n", e, r, t)
  fmt.Printf("\n-------\n")
  var age = 3

  if age > 2 {
    fmt.Printf("Age is %d\n", age)
  }

  fmt.Printf("\n-------\n")
  var arr [5] float64
  arr = [5]float64 {0.1, 0.2, 0.3,0.4,0.5}
  fmt.Println(arr[0])

  var arr1 = [2] string {"hello", "go"}
  fmt.Println(arr1[0])


  //pointer
  //https://blog.csdn.net/soonfly/article/details/51131141
  fmt.Printf("\n-------\n")

  var movies = [3] string {"a", "b", "c"}

  var p *string;
  p = &movies[0];
  var ptr **string = &p; 
  fmt.Println(*p);
  fmt.Println(**ptr);





}




	

