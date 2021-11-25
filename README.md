<h1>CodeBreaker <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="32" height="32"/></h1>

> This is CodeBreaker written in Java.  
[What is the origin of CodeBreaker?](https://en.wikipedia.org/wiki/Bulls_and_Cows) (Bulls and Cows, Hit and Blow)

## How to play

Only execute bat file.

```shell
$ run.bat
```
![eyecatch](https://cdn.discordapp.com/attachments/913437740647976970/913438638438776892/unknown.png)

## Document
### `public CodeBreaker(int maxNumber, int codeLength)`
#### `maxNumber`
> Default: 7

You can specify a maximum value for the code. This must be less than 10.
#### `codeLength`
> Default: 3

You can specify a length value for the code. This must be less than `maxNumber`.
#### Example
```java
// generate a code that max number is 7 and length is 3
CodeBreaker game = new CodeBreaker();

// generate a code that max number is 9 and length is 4
CodeBreaker game = new CodeBreaker(9, 4);
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://github.com/tenzyu/CodeBreaker/blob/master/LICENSE)
