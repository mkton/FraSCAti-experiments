mkdir -p .m2/repository/org/ow2/frascati/factory/
cp -R ~/.m2/repository/org/ow2/frascati/factory/frascati-factory-plugin/ ./.m2/repository/org/ow2/frascati/factory/
cp -R ~/.m2/repository/org/ow2/frascati/frascati-runtime/  ./.m2/repository/org/ow2/frascati/
cp -R ~/.m2/repository/org/ow2/frascati/frascati-tinfi-juliac-oo/ .m2/repository/org/ow2/frascati/

mkdir -p .m2/repository/org/ow2/frascati/tinfi/
cp -R ~/.m2/repository/org/ow2/frascati/tinfi/frascati-tinfi-oo/ .m2/repository/org/ow2/frascati/tinfi/

mkdir -p .m2/repository/org/objectweb/fractal/juliac/
cp -R ~/.m2/repository/org/objectweb/fractal/juliac/juliac-oo/ .m2/repository/org/objectweb/fractal/juliac/
cp -R ~/.m2/repository/org/objectweb/fractal/bf/ .m2/repository/org/objectweb/fractal/


tar -czf mvn-repo.tar.gz .m2/
rm -R .m2/
