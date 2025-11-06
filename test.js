function add(a, b) {
  return a + b;
}

function printArray(arr) {
  let i = 0;
  while (i < arr.length) {
    print(arr[i]);
    i = i + 1;
  }
}

let student = {
  name: "Abdullah",
  age: 22,
  grades: [85, 90, 88]
};

let sum = add(10, 15);
print("Sum = " + sum);

if (student.age > 18) {
  print(student.name + " is adult");
} else {
  print(student.name + " is minor");
}

print("Grades:");
printArray(student.grades);
