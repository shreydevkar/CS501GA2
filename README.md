# Spring 2026 CS501 Group Assignment 2
Groupmates: 
- Nicholas Sima - nicksima@bu.edu
- Shrey Devkar - shreyd@bu.edu

## Question 1: What makes Compose Declarative?

In Compose, you describe what the UI should look like based on current state, now how to update it.
In our code, ChildComposable declares that a column should contain a Text and Button with certain values.
When state changes, Compose automatically figures out what needs to update rather than requiring
additional setting logic.


## Question 2: Where is state stored?

State is stored in ParentComposable using remember {mutableStateOf()}. The remember function
tells Compose to preserve these values across recompositions, while mutableStateOf makes them
observable so Compose knows to recompose when they change.


## Question 3: Which Composables are stateful vs stateless?

ParentComposable is stateful because it owns and manages isDarkMode and wasClicked using remember.
ChildComposable is stateless because it has no internal state and receives it through parameters,
communicating changes back to the parent through its lambda callback.

## Question 4: How does this differ from XML + View logic?

With XML, you had to define static layouts in XML files and then manage views in Kotlin code.
Compose eliminates this separation entirely as the UI and logic both live in Kotlin. State changes
automatically trigger UI updates without manual view references, and there's no need to maintain 
synchronization between layout and logic. 
