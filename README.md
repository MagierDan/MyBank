#MyBank Application

This project has has two main goals :
- to be integrated in a DevOps workflow
- to use the market current best practices in software development

The domain expressed is the banking one in it's simpliest way.

Consumers should be able to make rest calls to create banking accounts and do some operations 
like withdrawals, deposits, etc ...)

# 1 - Integration into a DevOps workflow

## What is DevOps ?

### [Gartner definition:](https://www.gartner.com/it-glossary/devops)

DevOps represents a change in IT culture, focusing on rapid IT service delivery through the adoption of agile, lean 
practices in the context of a system-oriented approach.

DevOps emphasizes people (and culture), and seeks to improve collaboration between operations and development teams.

DevOps implementations utilize technology — especially automation tools that can leverage an increasingly programmable 
and dynamic infrastructure from a life cycle perspective.

### The protagonists

- The "Devs" part represent every people implicated by making the software : the developers, the business and the QAs.
Their goal is to add new features, they want changes.

- The "Ops" represent part every people implicated in managing and maintaining the production : systems, security and 
networks engineers, and DBAs.
Their goal is to easily manage the production, they want stability.

Both parts have antagonist goals

### How to achieve this goals
- feature teams : Biz, Dev, Ops and QA in one team to do the entire life cycle of a feature. Facilitate communications 
and informations sharing. In terms of size, think pizza shares
- continuous integration : test, build and deploy at each code modification to see if regressions are presents and fix 
it the ealier
- shift left testing : early automated users acceptance tests (UAT) executed in the Continous Integration
- tests are done on environments similar to production to avoid late surprises
- short feed back loop, fail fast
- production monitoring

### DevOps principles : C.A.L.M.S

- Culture
- Automation
- Lean
- Measurement
- Sharing

## DevOps in practice

### The "Dev" part
In 

# 2 - Software architecture

## DDD 
Ubiquitous language

## BDD 
Cucumber + Tatziki
Specifications by examples

## TDD
AssertJ + Mockito

## Hexagonal architecture
Multi modules: domain (the most important module), infrastructure for the technical and expostion to expose our api

## No ORM:  MyBatis to manage SQL queries
DBA and Devs can integrate SQL query and fetch the results in domain Objects quite easily

## Liquibase
Database version control and deployment

## Exposition Rest
Swagger2











