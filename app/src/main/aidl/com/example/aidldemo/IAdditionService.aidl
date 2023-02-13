// IAdditionService.aidl
package com.example.aidldemo;

// Declare any non-default types here with import statements

interface IAdditionService {
   int add(in int x, in int y);
   int subtract(in int x, in int y);
   int multiply(in int x, in int y);
}