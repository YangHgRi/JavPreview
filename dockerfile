FROM --platform=linux/amd64 ubuntu
ENV JAVA_DIR=/usr/local
COPY /home/yanghgri/jar/OpenJDK8U-jdk_x64_linux_hotspot_8u322b06.tar.gz $JAVA_DIR/
COPY /home/yanghgri/jar/AVP.jar /tmp/AVP.jar
RUN cd $JAVA_DIR \
&& tar -xf ./OpenJDK8U-jdk_x64_linux_hotspot_8u322b06.tar.gz \
&& mv ./jdk8u322-b06 ./jdk8
ENV JAVA_HOME=$JAVA_DIR/jdk8
ENV PATH=$PATH:$JAVA_HOME/bin
EXPOSE 8090
ENTRYPOINT java -jar /tmp/AVP.jar