# Data Structures and Algorithm Assignments

## Latex
- [LuaTex](https://www.luatex.org/) is the Tex engine of choice if you plan to edit LaTeX files locally.  

### Document configuration
| Option            | Value        |
|:------------------|:-------------|
| `oddsidemargine`  | .25in        |
| `evensidemargin`  | .25in        |
| `textwidth`       | 6in          |
| `topmargin`       | -0.4in       |
| `textheight`      | 8.5in        |
| Upright font face | Roboto Light |
| Bold font face    | Roboto Bold  |
| Font size         | 11pt         |

### Functions
```tex
% Assignment header with the appropriate information
% 1st arg: Group member names
% 2nd arg: Assignment #
\newcommand{\header}[2]{
  \begin{center}
	\setlength\fboxsep{.3cm}
	\doublebox{
		\parbox{\textwidth} {
			#1 \\
			COSC 336 \\
			\today \par
			\centering{\huge{Assignment #2}}
		}}
\end{center}
}
```

## Java
| Option          | Value                                                         |
|:---------------:|:-------------------------------------------------------------:|
| Indent          | 4                                                             |
| Case (optional) | [Snake](https://www.theserverside.com/definition/Snake-case) |
| Version         | 16.0.1                                                        |

