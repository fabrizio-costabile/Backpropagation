<div id="top"></div>

# Backpropagation
Implementation of the Backpropagation algorithm to train Feedforward Neural Networks.

<!-- ABOUT THE PROJECT -->
## About The Project

The algorithm implements the pseudocode found in "Artificial Intelligence: A Modern Approach (Third Edition)" by Stuart Russell and Peter Norvig (on page 734, Chapter 18).
<br>

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

* Java
* JUnit
* Maven

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

The project's /docs folder contains the UML Class Diagram of this project.

![Backpropagation - UML Class Diagram](https://github.com/fabrizio-costabile/backpropagation/blob/master/docs/uml-class-diagram.png?raw=true) 

### Prerequisites

An IDE to import Java projects and run JUnit tests.

<!-- USAGE EXAMPLES -->
## Usage

Download the source code and run the "SinusoidPredictionTest.java" JUnit test.
The unit test will proof the validity of the algorithm's implementation. 
<br>
<br>
Example of usage:
```
Backpropagation backpropagation = new Backpropagation(SIZES_OF_LAYERS, new SigmoidFunction());
backpropagation.learn(dataSet, 1, 0);
double[] predictions = backpropagation.predict(inputs);
```
A comprehensive usage can be found in the "SinusoidPredictionTest.java" JUnit test.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- LICENSE -->
## License

Backpropagation is licensed under the Apache License, Version 2.0. See <a href="https://github.com/fabrizio-costabile/backpropagation/blob/master/LICENSE">LICENSE</a> for the full license text.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Fabrizio Costabile - Project Link: [https://github.com/fabrizio-costabile/backpropagation](https://github.com/fabrizio-costabile/backpropagation)

<p align="right">(<a href="#top">back to top</a>)</p>