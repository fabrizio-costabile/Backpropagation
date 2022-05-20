# Backpropagation
Implementation of the Backpropagation algorithm to train Feedforward Neural Networks.

<!-- ABOUT THE PROJECT -->
## About The Project

This project implements the Backpropagation algorithm defined in pseudocode in "Artificial Intelligence: A Modern Approach (Third Edition)", by Stuart Russell and Peter Norvig, on page 734 (Chapter 18).
<br>

### Built With

* Java
* JUnit
* Maven

<!-- GETTING STARTED -->
## Getting Started

UML class diagram (located in **/docs** folder) showing the use of a **Template Pattern**.

![Backpropagation - UML Class Diagram](https://raw.githubusercontent.com/fabrizio-costabile/Backpropagation/main/docs/uml-class-diagram.png) 

### Prerequisites

An IDE to import Java (Maven) projects and run JUnit tests.

<!-- USAGE EXAMPLES -->
## Usage

A comprehensive usage can be found in the <code>SinusoidPredictionTest</code> JUnit test, 
that validates the algorithm's implementation by generating a "good" **Mean Absolute Error** (MAE < 10%).

### Example of usage:
```
Backpropagation backpropagation = new Backpropagation(SIZES_OF_LAYERS, new SigmoidFunction());
backpropagation.learn(dataSet, 1, 0);
double[] predictions = backpropagation.predict(inputs);
```

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

<!-- LICENSE -->
## License

**Backpropagation** is licensed under the Apache License, Version 2.0. See <a href="https://github.com/fabrizio-costabile/backpropagation/blob/master/LICENSE">LICENSE</a> for the full license text.

<!-- CONTACT -->
## Contact

Fabrizio Costabile - Project Link: [https://github.com/fabrizio-costabile/backpropagation](https://github.com/fabrizio-costabile/backpropagation)

