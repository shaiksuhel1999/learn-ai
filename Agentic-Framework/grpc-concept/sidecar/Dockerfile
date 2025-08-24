FROM python:alpine3.21@sha256:f5f25747d6589917174824189a07ed31051ec6312a7e069a7c3498bbc935f0c3
WORKDIR /app
COPY . .
RUN pip install grpcio grpcio-tools
CMD ["python", "server.py"]