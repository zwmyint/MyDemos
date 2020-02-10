package main
import (
	"fmt"
	"strings"
	"math"
)

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

  var p *string
  p = &movies[0]
  var ptr **string = &p;
  fmt.Println(*p)
	fmt.Println(**ptr)

	//Func
	fmt.Printf("\n-------\n")
	foo("Tom");
	fmt.Println(foo1("Lyn"))

	//string apis
	fmt.Printf("\n-------\n")

	var sname = "tom_SH"
	var saddr = "SH"

	fmt.Println(strings.Compare(sname, saddr))
	fmt.Println(strings.Contains(sname, saddr))
	fmt.Println(strings.Contains(sname, saddr))
	fmt.Println(strings.Count("cheese", "e"))
	fmt.Println(strings.EqualFold("Go", "go"))
	fmt.Println(strings.HasPrefix("Gopher", "Go"))
	fmt.Println(strings.HasSuffix("Gopher", "Go"))

	s := []string{"foo", "bar", "baz"}
	fmt.Println(strings.Join(s, ", "))
	fmt.Println(strings.Index("go gopher", "go"))
	fmt.Println(strings.LastIndex("go gopher", "go"))
	fmt.Println(strings.LastIndex("go gopher", "rodent"))

	//最后一个表示执行替换几次
	fmt.Println(strings.Replace("oink oink oink", "k", "ky", 2))
	fmt.Println(strings.Replace("oink oink oink", "oink", "moo", -1))
	fmt.Println(strings.ReplaceAll("oink oink oink", "oink", "moo"))

	fmt.Printf("%q\n", strings.Split("a,b,c", ","))
	fmt.Printf("%q\n", strings.Split("a man a plan a canal panama", "a "))
	fmt.Printf("%q\n", strings.Split("", "Bernardo O'Higgins"))

	fmt.Println(strings.ToLower("Gopher"))
	fmt.Println(strings.ToUpper("Gopher"))

	fmt.Println(strings.ToTitle("loud noises"))

	fmt.Println(strings.Trim("¡¡¡Hello, Gophers!!!", "!¡"))
	fmt.Println(strings.Trim(" Hello, Gophers", " "))

	//Array
	fmt.Printf("\n-------\n")

	var fruit = [3] string {"apple", "banana", "orange"}
	var i int;
	//var pFruit *[3]string
	for i = 0; i< len(fruit); i++ {
		fmt.Println(fruit[i])
	}

	//struct
	fmt.Printf("\n-------\n")
	type Book struct {
		title string
		id int
	}

	var book Book
	book.title = "C++"
	book.id = 1

	var pbook *Book
	pbook=&book
	fmt.Println(pbook.id)

	//Slices
	fmt.Printf("\n-------\n")

	var nums = []int {1, 2, 3}
	fmt.Println(nums[1])
	fmt.Println(len(nums))

	var nums1 = make([]int, 3, 5)
	fmt.Println(nums1[0])
	fmt.Println(nums1[1])
	fmt.Println(nums1[2])
	//fmt.Println(nums1[3])
	//fmt.Println(nums1[4])
	fmt.Println(len(nums1))
	fmt.Println(cap(nums1))

	//Subslicing
	var strs []string 
	strs = strings.Split("Because of the 2019-nCov outbreak, I stay home for a long time.", " ")
	var strssub []string
	strssub = strs[0:10]
	fmt.Println(strssub[1])

	var strssub1 []string
	fmt.Println(len(strs))
	//Must make before copy!!!
	strssub1 = make([]string, len(strs))
	copy(strssub1, strs)
	fmt.Println(len(strssub1))

	var strssub2 []string
	strssub2 = append(strs, "hello")
	fmt.Println(strssub2)

	//Range on array
	fmt.Printf("\n-------\n")
	for index := range strs {
		fmt.Printf("%d, %s\n", index, strs[index])
	}

	//Range on map
	countryCapitalMap := map[string] string {"France":"Paris","Italy":"Rome","Japan":"Tokyo"}
	for country, captial := range countryCapitalMap {
		fmt.Printf("%s --> %s\n", country, captial)
	}

	//Map

	var cats map[string]string
	cats = make(map[string]string)
	cats["red"] = "red_cat"
	cats["green"] = "green_cat"
	cats["gray"] = "gray_cat"

	for color:= range cats {
		fmt.Printf("%s --> %s\n", color, cats[color])
	}

	// is exist
	cat, ok := cats["green"]
	if ok {
		fmt.Printf("exist %s\n", cat)
	} else {
		fmt.Printf("nil")
	}

	// delete
	delete(cats, "red");
	fmt.Printf("\n-------\n")
	for color:= range cats {
		fmt.Printf("%s --> %s\n", color, cats[color])
	}

	// recursion
	fmt.Printf("\n-------\n")
	fmt.Println(fact(1))
	fmt.Println(fact(5))

	//interface
	fmt.Printf("\n-------\n")

	circle := Circle{x:0,y:0,radius:5}
  rectangle := Rectangle {width:10, height:5}
   
  fmt.Printf("Circle area: %f\n",getArea(circle))
  fmt.Printf("Rectangle area: %f\n",getArea(rectangle))

	
}

func foo(name string) {
	fmt.Printf("Your name is %s\n", name);
}

func foo1 (name string) string {
	return "Your name is " + name;
}


func fact (num int) int {
	if num <=1 {
		return 1
	} else {
		return num * fact(num -1 )
	}
}

//interface 
type Shape interface {
	area() float64
}

type Circle struct {
	x, y, radius float64
}

type Rectangle struct {
	width, height float64
}

func (circle Circle) area() float64 {
	return math.Pi * circle.radius * circle.radius
}

func(rect Rectangle) area() float64 {
	return rect.width * rect.height
}

func getArea(shape Shape) float64 {
	return shape.area()
}




	

