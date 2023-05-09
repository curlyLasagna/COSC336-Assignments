# Data Structures and Algorithm Assignments
Contains all of the assignments my team and I have submitted for COSC 336.
I cannot guarantee the correctness of our solutions, so thread the codebase with skepticism.
## Latex
- [LuaTex](https://www.luatex.org/) is the Tex engine of choice if you plan to edit LaTeX files locally. Otherwise, the rest of my team has opted to use [Overleaf](https://www.overleaf.com/) for real time collaboration.

### Document configuration
| Option            | Value        |
|:------------------|:-------------|
| `oddsidemargin`  | .25in        |
| `evensidemargin`  | .25in        |
| `textwidth`       | 6in          |
| `topmargin`       | -0.4in       |
| `textheight`      | 8.5in        |
| Font size         | 11pt         |

### User functions
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
|     Option      |                            Value                             |
| :-------------: | :----------------------------------------------------------: |
| Indent (Spaces)  |                              2                               |
| Case (optional) | [Snake](https://www.theserverside.com/definition/Snake-case) |
|     Version     |                            16.0.1                            |

