package main

import "fmt"
func main() {
    fmt.Println(identity(3));
}

func identity (x int) [][]float64{
	v := make ( [][]float64, x)
	for i := range v {
        v[i] = make([]float64, x)
    }
	for i := 0; i < x; i ++{
		for j := 0; j < x; j ++{
			if (i == j) {
				v [i][j] = 1
			}else{
				v [i][j] = 0
			}
		}
	}
	return v;
}


