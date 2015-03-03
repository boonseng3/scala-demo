name := "Scala demo"

version := "0.1"

scalaVersion := "2.11.4"

libraryDependencies ++= {
  Seq(
  	 
  )  
}

EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.Unmanaged, EclipseCreateSrc.Source, EclipseCreateSrc.Resource)

EclipseKeys.withSource := true
