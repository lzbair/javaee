Generate a customized SOA client from wsdl:  
- 1st option: using third part library (e.g. cxf)  
- 2nd option: using stnadrad java wsimport (jaxws)  
  

```
w2j 
│   build-cxf.xml  #Comment: target ant to generate SOA client using cxf#
│   build.xml      #Comment: target ant to generate SOA clinet using java ws#
│   readme.md
│
├───gensrc
├───lib
│       #Comment: dependecies needed only for cxf option#
│
└───wsdl
    └───myDomain
            jaxws-bindings.xml #Comment: jaxws customization#
            myWSDL.wsdl
```