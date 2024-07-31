# proof of concept for JIT module compolation for scala project

## Overview

The goal is to change runtime implemention for `dynamic_lib` module that ships example logic.
`jit_poc` loads jar and call `.foo()` functions

## How to run

1. `sbt run` in `jit_poc`
2. do changes in `dynamic lib`
3. recompile lib `sbt package`
4. put any text but 0 to `jit_poc` prompt
5. see module dynamically reloaded 

## Why?

why not? 
I coded this for quick research and thats it

